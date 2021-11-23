import React from 'react';

import "./FormEntry.scss";

const FormEntry = () => {
    return (
        <form className="entry__entry-form entry-form">

            <label htmlFor="email"></label>
            <input className="entry-form__input-text" type="email" id="password" name="email" placeholder="Ваш Email" />

            <label htmlFor="password"></label>
            <input className="entry-form__input-text" type="password" name="password" id="password" placeholder="Ваш пароль" />

            <div className="entry-form__remember">
                <label className="entry-form__checkbox" htmlFor="remember">
                    <input className="entry-form__input-checkbox" type="checkbox" name="remember" id="remember" />
                    <div>Запомнить меня</div>
                </label>
                <a href="#" className="entry-form__forget-password">Забыли пароль?</a>
            </div>

            <div className="entry-form__login">
                <input className="sign-up-button" type="submit" value="Войти" id="submit" />
                <h6 className="entry-form__registration" >Нет аккаунта? <a className="entry-form__sign-in" href="#">Регистрация</a></h6>
            </div>
        </form>
    );
};

export default React.memo(FormEntry);