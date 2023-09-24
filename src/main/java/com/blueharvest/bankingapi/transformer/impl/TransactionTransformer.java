package com.blueharvest.bankingapi.transformer.impl;

import com.blueharvest.bankingapi.domain.Transaction;
import com.blueharvest.bankingapi.transformer.ITransactionTransformer;

public class TransactionTransformer implements ITransactionTransformer {

    public Transaction toDTO(com.blueharvest.bankingapi.model.Transaction transaction) {
        Transaction dto = new Transaction();
        dto.setId(transaction.getId());
        dto.setAmount(transaction.getAmount());
        return dto;
    }

    public com.blueharvest.bankingapi.model.Transaction toModel(Transaction dto) {
        com.blueharvest.bankingapi.model.Transaction transaction = new com.blueharvest.bankingapi.model.Transaction();
        transaction.setId(dto.getId());
        transaction.setAmount(dto.getAmount());
        return transaction;
    }
}
