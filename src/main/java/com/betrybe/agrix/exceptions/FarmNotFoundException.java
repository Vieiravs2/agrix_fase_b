package com.betrybe.agrix.exceptions;

/**
* Custom exception for farm not found.
*/
public class FarmNotFoundException extends RuntimeException {
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}