import React from 'react';
import {Link} from "react-router-dom";

import './HeaderEnrty.scss';

import { routes } from '@configs/routes';

const HeaderEntry = () => {

    return (
        <header className="header-entry">
            <div className="header-entry__inner">
                <Link className="header-entry__links" to={routes.home.index}>
                    <img className="header-entry__logo logo" src="./img/logo.png" alt="123"/>
                    <h2 className="header-entry__title"><span className="logo--dark-green">S</span>moothie<span
                        className="logo--dark-green">F</span>eed</h2>
                </Link>
            </div>
        </header>
    );
};

export default React.memo(HeaderEntry);