import React, { useContext } from 'react';
import { GlobalContext } from '../../../context/GlobalState';

export const Balance = () => {
  const { transactions } = useContext(GlobalContext);

  const amounts = transactions.map(transaction => transaction.amount);

  const quantitiesPeople = transactions.map(transaction => transaction.quantityPeople);

  const expensePerPeople = amounts.reduce((acc, item) => ((acc += item/quantitiesPeople)*-1), 0).toFixed(2);

  const total = amounts.reduce((acc, item) => (acc += item), 0).toFixed(2);

  return (
    <>
      <h1>SEU SALDO</h1>
      <h1>R${total}</h1>
      <br/>
      <h1>Despesas por pessoa</h1>
      <h1>R${expensePerPeople}</h1>
    </>
  )
}