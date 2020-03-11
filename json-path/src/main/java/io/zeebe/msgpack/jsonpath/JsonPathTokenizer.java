/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH under
 * one or more contributor license agreements. See the NOTICE file distributed
 * with this work for additional information regarding copyright ownership.
 * Licensed under the Zeebe Community License 1.0. You may not use this file
 * except in compliance with the Zeebe Community License 1.0.
 */
package io.zeebe.msgpack.jsonpath;

import io.zeebe.msgpack.util.ByteUtil;
import java.nio.charset.StandardCharsets;
import org.agrona.DirectBuffer;

public final class JsonPathTokenizer {

  public static final StaticToken SYMBOL_ROOT_OBJECT =
      new StaticToken(JsonPathToken.ROOT_OBJECT, "$".getBytes(StandardCharsets.UTF_8));
  public static final StaticToken SYMBOL_CHILD_OPERATOR =
      new StaticToken(JsonPathToken.CHILD_OPERATOR, ".".getBytes(StandardCharsets.UTF_8));
  public static final StaticToken SYMBOL_RECURSION_OPERATOR =
      new StaticToken(JsonPathToken.RECURSION_OPERATOR, "..".getBytes(StandardCharsets.UTF_8));
  public static final StaticToken SYMBOL_WILDCARD =
      new StaticToken(JsonPathToken.WILDCARD, "*".getBytes(StandardCharsets.UTF_8));
  public static final StaticToken SYMBOL_SUBSCRIPT_OPERATOR_BEGIN =
      new StaticToken(JsonPathToken.SUBSCRIPT_OPERATOR_BEGIN, "[".getBytes(StandardCharsets.UTF_8));
  public static final StaticToken SYMBOL_SUBSCRIPT_OPERATOR_END =
      new StaticToken(JsonPathToken.SUBSCRIPT_OPERATOR_END, "]".getBytes(StandardCharsets.UTF_8));
  public static final StaticToken SYMBOL_CHILD_BRACKET_OPERATOR_BEGIN =
      new StaticToken(
          JsonPathToken.CHILD_BRACKET_OPERATOR_BEGIN, "['".getBytes(StandardCharsets.UTF_8));
  public static final StaticToken SYMBOL_CHILD_BRACKET_OPERATOR_END =
      new StaticToken(
          JsonPathToken.CHILD_BRACKET_OPERATOR_END, "']".getBytes(StandardCharsets.UTF_8));

  protected static final StaticToken[] CHILD_BRACKET_END_TOKENS = {
    SYMBOL_CHILD_BRACKET_OPERATOR_END
  };
  protected static final StaticToken[] STATIC_TOKENS = new StaticToken[8];

  static {
    STATIC_TOKENS[0] = SYMBOL_ROOT_OBJECT;
    STATIC_TOKENS[1] = SYMBOL_RECURSION_OPERATOR;
    STATIC_TOKENS[2] = SYMBOL_CHILD_OPERATOR;
    STATIC_TOKENS[3] = SYMBOL_WILDCARD;
    STATIC_TOKENS[4] = SYMBOL_CHILD_BRACKET_OPERATOR_BEGIN;
    STATIC_TOKENS[5] = SYMBOL_CHILD_BRACKET_OPERATOR_END;
    STATIC_TOKENS[6] = SYMBOL_SUBSCRIPT_OPERATOR_BEGIN;
    STATIC_TOKENS[7] = SYMBOL_SUBSCRIPT_OPERATOR_END;
  }

  public void tokenize(
      final DirectBuffer buffer,
      final int offset,
      final int length,
      final JsonPathTokenVisitor tokenVisitor) {
    int position = offset;
    int lastStaticTokenEndPosition = position;
    tokenVisitor.visit(JsonPathToken.START_INPUT, buffer, offset, length);
    StaticToken[] tokens = STATIC_TOKENS;

    boolean childBracketNotation = false;
    while (position < length) {
      JsonPathToken currentToken = null;
      for (int i = 0; i < tokens.length && currentToken == null; i++) {
        final StaticToken token = tokens[i];
        final byte[] tokenRepresentation = token.representation;
        if (ByteUtil.equal(tokenRepresentation, buffer, position, tokenRepresentation.length)) {
          if (lastStaticTokenEndPosition < position) {
            tokenVisitor.visit(
                JsonPathToken.LITERAL,
                buffer,
                lastStaticTokenEndPosition,
                position - lastStaticTokenEndPosition);
          }

          childBracketNotation = token == SYMBOL_CHILD_BRACKET_OPERATOR_BEGIN;
          tokenVisitor.visit(token.token, buffer, position, tokenRepresentation.length);
          position += tokenRepresentation.length;
          lastStaticTokenEndPosition = position;
          currentToken = token.token;
        }
      }

      if (currentToken == null) {
        position++;
      } else if (childBracketNotation) {
        tokens = CHILD_BRACKET_END_TOKENS;
      } else {
        tokens = STATIC_TOKENS;
      }
    }

    if (lastStaticTokenEndPosition < position) {
      tokenVisitor.visit(
          JsonPathToken.LITERAL,
          buffer,
          lastStaticTokenEndPosition,
          position - lastStaticTokenEndPosition);
    }
    tokenVisitor.visit(JsonPathToken.END_INPUT, buffer, offset, length);
  }

  protected static class StaticToken {
    protected final JsonPathToken token;
    protected final byte[] representation;

    public StaticToken(final JsonPathToken token, final byte[] representation) {
      this.token = token;
      this.representation = representation;
    }
  }
}
