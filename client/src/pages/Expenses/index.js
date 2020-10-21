import React from 'react';
import { Balance } from '../../components/partials/ExpensesFuntions/Balance';
import { IncomeExpenses } from '../../components/partials/ExpensesFuntions/IncomeExpenses';
import { TransactionList } from '../../components/partials/ExpensesFuntions/TransactionList';
import { AddTransaction } from '../../components/partials/ExpensesFuntions/AddTransactions';
import { PageArea } from './styled';
import { PageContainer } from '../../components/MainComponents'

import { GlobalProvider } from '../../context/GlobalState';

import './Expenses.css';



const Expenses = () => {

    return (
        <PageContainer>
            <PageArea>
            <GlobalProvider>
                <div className="container">
                    <Balance />
                    <IncomeExpenses />
                    <TransactionList />
                    <AddTransaction />
                </div>
            </GlobalProvider>
            </PageArea>
        </PageContainer>
    );
}

export default Expenses;
