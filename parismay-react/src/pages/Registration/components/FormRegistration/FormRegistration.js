import React from 'react';
import {Link} from "react-router-dom";

import { routes } from '@configs/routes';

import "./FormRegistration.scss";



const FormRegistration = () => {
    return (
        <form className="registration__form form">
            <label htmlFor="name"></label>
            <input className="form__input-text" type="text" id="name" name="name" placeholder="Ваше имя" />

            <label htmlFor="email"></label>
            <input className="form__input-text" type="email" id="password" name="email" placeholder="Ваш Email" />

            <label htmlFor="password"></label>
            <input className="form__input-text" type="password" name="password" id="password" placeholder="Пароль" />

            <label htmlFor="repeat-password"></label>
            <input className="form__input-text" type="password" name="repeat-password" id="repeat-password" placeholder="Повторите пароль" />

            <div className="form__login">
                <input className="sign-up-button" type="submit" value="Зарегистрироваться" id="submit" />
                <h6 className="form__registration" >Уже зарегистрированы? <Link className="form__sign-in" to={routes.auth.index}>Войдите</Link></h6>
            </div>
        </form>
    );
};

export default React.memo(FormRegistration);