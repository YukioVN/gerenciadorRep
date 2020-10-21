import React from 'react';
import { PageArea } from './styled';

import { PageContainer } from '../../components/MainComponents';
import TodoList  from '../../components/partials/TodoList/TodoList';

import './Tasks.css';

const Tasks = () => {
 
    return (
        <PageContainer>
            <PageArea>
            <div className='todo-app'>
                <TodoList />
            </div>        
            </PageArea>
        </PageContainer>
    );
}

export default Tasks;