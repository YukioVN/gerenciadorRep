import React, {useState, useContext} from 'react'
import { GlobalContext } from '../../../context/GlobalState';

export const AddTransaction = () => {
  const [text, setText] = useState('');
  const [amount, setAmount] = useState('');
  const [quantityPeople, setQuantityPeople] = useState('');

  const { addTransaction } = useContext(GlobalContext);

  const onSubmit = e => {
    e.preventDefault();

    const newTransaction = {
      id: Math.floor(Math.random() * 100000000),
      text,
      amount: +amount,
      quantityPeople: +quantityPeople
    }

    addTransaction(newTransaction);
  }

  return (
    <>
      <h3>Adicione uma nova transação</h3>
      <form onSubmit={onSubmit}>
        <div className="form-control">
          <label htmlFor="text">Descreva com mais detalhe</label>
          <input type="text" value={text} onChange={(e) => setText(e.target.value)} placeholder="Insira um texto" />
        </div>
        <div className="form-control">
          <label htmlFor="text">Digite quantidade de pessoas para dividir as despesas</label>
          <input type="number" value={quantityPeople} onChange={(e) => setQuantityPeople(e.target.value)} placeholder="Insira quantidade de pessoas" />
        </div>
        <div className="form-control">
          <label htmlFor="amount"
            >Montante <br />
            **OBS.**(Valor negativo: desconto, valor positivo: acréscimo)
          </label>
          <input type="number" value={amount} onChange={(e) => setAmount(e.target.value)} placeholder="Insira um valor" />
        </div>
        <button className="btn">Adicionar transação</button>
      </form>
    </>
  )
}