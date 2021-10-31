import React from 'react';

const Header = () => {
    return (
        <header className="header">
            <div className="header__logo"></div>
            <nav className="header__nav nav">
                <ul className="nav__list">
                    <li className="nav__li"></li>
                    <li className="nav__li"></li>
                    <li className="nav__li"></li>
                    <li className="nav__li"></li>
                    <li className="nav__li"></li>
                </ul>
            </nav>
            <div className="header__profile profile">
                <div className="profile__icon"></div>
                <div className="profile__name"></div>
            </div>
        </header>
    );
};

export default Header;