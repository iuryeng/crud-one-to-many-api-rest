package com.projeto.crudonetomayapirest.exception;

import java.text.MessageFormat;

public class ComputadorIsAlreadyAssingnedException extends RuntimeException {
    public ComputadorIsAlreadyAssingnedException(final Long computadorID, final Long colaboradorId ){
        super(MessageFormat.format("Compuador de id {0}  está pronto para colaborador id {1} ", computadorID, colaboradorId));
    }
}
