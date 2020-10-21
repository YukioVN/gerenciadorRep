import React from 'react';
import * as FaIcons from "react-icons/fa";
import * as AiIcons from "react-icons/ai";
import * as IoIcons from "react-icons/io";

export const SidebarData = [
    {
        title: 'Início',
        path: '/',
        icon: <AiIcons.AiFillHome />,
        cName: 'nav-text'
    },
    {
        title: 'Tarefas',
        path: '/Tasks',
        icon: <FaIcons.FaTasks />,
        cName: 'nav-text'
    },
    {
        title: 'Contas',
        path: '/Expenses',
        icon: <IoIcons.IoMdCalculator />,
        cName: 'nav-text'
    },
    {
        title: 'Eventos',
        path: '/Events',
        icon: <FaIcons.FaCalendarAlt />,
        cName: 'nav-text'
    },
    {
        title: 'Regras',
        path: '/Rules',
        icon: <FaIcons.FaRegClipboard />,
        cName: 'nav-text'
    },
    {
        title: 'Ranking',
        path: '/Ranking',
        icon: <AiIcons.AiFillTrophy />,
        cName: 'nav-text'
    },
];