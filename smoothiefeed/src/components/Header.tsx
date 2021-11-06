import React from 'react';

const Header = () => {
    return (
        <div className="wrapper">
            <header className="header">
                <div className="container--lg">
                    <div className="header__inner">
                        <a href="#">
                            <img className="header__logo logo" src="/img/logo.png" alt="123" />
                        </a>
                        <nav className="header__nav nav">
                            <ul className="nav__list">
                                <li className="nav__li"><a href="#">Главная</a></li>
                                <li className="nav__li"><a href="#">Посты</a></li>
                                <li className="nav__li"><a href="#">Выбор детокса</a></li>
                                <li className="nav__li"><a href="#">Достижения</a></li>
                                <li className="nav__li"><a href="#">О приложении</a></li>
                            </ul>
                        </nav>
                        <a className="header__profile profile" href="#">
                            <svg width="40" height="40" viewBox="0 0 56 56" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <ellipse cx="27.6579" cy="27.5987" rx="27.6579" ry="27.5987" fill="#A36E5C"/>
                                <path
                                    d="M27.1361 32.806C15.6555 32.806 11.4807 48.9486 11.4807 48.9486H17.2209H37.0511H43.8352C43.8352 48.9486 38.6167 32.806 27.1361 32.806Z"
                                    stroke="#E6F6D1" stroke-width="2"/>
                                <path
                                    d="M36.573 22.912C36.573 28.1096 32.3499 32.3266 27.136 32.3266C21.9221 32.3266 17.6991 28.1096 17.6991 22.912C17.6991 17.7145 21.9221 13.4974 27.136 13.4974C32.3499 13.4974 36.573 17.7145 36.573 22.912Z"
                                    stroke="#E6F6D1" stroke-width="2"/>
                            </svg>
                            <p className="profile__name">Вход</p>
                        </a>
                        <a className="header__switch-theme switch-theme" href="#">
                            <svg width="19" height="24" viewBox="0 0 19 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path
                                    d="M0.643489 12.0139C0.744396 13.745 1.32535 15.4237 2.33931 16.9142C3.35326 18.4046 4.77173 19.6648 6.47987 20.5928C8.18801 21.5208 10.1378 22.0905 12.1714 22.2558C14.205 22.421 16.2653 22.1772 18.1854 21.544C15.5004 20.9948 13.1089 19.7302 11.3587 17.9343C9.60846 16.1383 8.59087 13.9045 8.45392 11.558C8.31697 9.2115 9.06782 6.87457 10.5972 4.88718C12.1266 2.89979 14.3548 1.36561 16.9577 0.507804C14.977 0.102291 12.9023 0.0997771 10.9018 0.500466C8.90118 0.901155 7.03088 1.69379 5.44229 2.81418C3.85369 3.93458 2.59145 5.35126 1.75775 6.94953C0.924056 8.54779 0.542333 10.2827 0.643489 12.0139Z"
                                    fill="black" fill-opacity="0.89"/>
                            </svg>

                        </a>
                    </div>
                </div>
            </header>
            <div className="bg"></div>
        </div>

    );
};

export default Header;