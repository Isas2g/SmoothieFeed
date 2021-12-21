import React from 'react';
import {Link} from "react-router-dom";

import { routes } from '@configs/routes';

import "./FormEntry.scss";

const FormEntry = () => {
    return (
        <form className="entry__form form">

            <label htmlFor="email"></label>
            <input className="form__input-text" type="email" id="password" name="email" placeholder="Ваш Email" />

            <label htmlFor="password"></label>
            <input className="form__input-text" type="password" name="password" id="password" placeholder="Ваш пароль" />

            <div className="form__remember">
                <label className="form__checkbox" htmlFor="remember">
                    <input className="form__input-checkbox" type="checkbox" name="remember" id="remember" />
                    <div>Запомнить меня</div>
                </label>
                <a href="#" className="form__forget-password">Забыли пароль?</a>
            </div>

            <div className="form__login">
                <input className="sign-up-button" type="submit" value="Войти" id="submit" />
                <h6 className="form__registration" >Нет аккаунта? <Link className="form__sign-in" to={routes.registration.index}>Регистрация</Link></h6>
            </div>
        </form>
    );
};

export default React.memo(FormEntry);