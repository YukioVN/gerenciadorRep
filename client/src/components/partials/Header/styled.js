import styled from 'styled-components';

export const HeaderArea = styled.div`
    background-color: #212121;
    height: 60px;
    border-bottom: 1px solid #;


    .container {
        max-width:1000px;
        margin: auto;
        display: flex;
    }

    a {
        text-decoration: none;
    }

    .menu-bars {
        font-size: 27px;
        color: #000;
        margin-right: 30px;
        margin-top: 10px;
    }

    .logo {
        flex: 1;
        display: flex;
        height: 60px;
        

        .logo-1 {
            display: flex;
            font-weight: bold;
            color: #ff0000;
            height: 60px;
            width: 125px;
            align-items: center;
        }
    }

    nav {
        padding-top: 10px;
        padding-bottom:10px;

        ul, li {
            margin: 0;
            padding: 0;
            list-style: none;
        }

        ul {
            display: flex;
            align-items: center;
            height: 40px;
        }

        li {
            margin-left: 20px;
            margin-right: 20px;
            

            a, button {
                border: 0;
                background: none;
                color: #FFF;
                font-size: 14px;
                text-decoration: none;
                cursor: pointer;
                outline: 0;

                &:hover {
                    color: #999;
                }

                &.button {
                    background-color: #FF8100;
                    border-radius: 4px;
                    color: #FFF
                    padding: 5px 10px;
                }

                &.button:hover {
                    background-color: #E57706;
                }
            }
        }

    }

`;