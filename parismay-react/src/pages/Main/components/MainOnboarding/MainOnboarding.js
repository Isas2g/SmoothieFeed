import React from 'react';
import { Link } from 'react-router-dom';

import woman from '@assets/images/onboarding-main.png';

import "./MainOnboarding.scss";

import { routes } from '@configs/routes';

const MainOnboarding = ({display}) => {
    return (
        <div className={"onboarding" + (display !== undefined ? " " + display : "")}>
            <img className="onboarding__woman" src={woman} alt="onboarding" />
            <div className="onboarding__dots">
                <Link to={routes.home.index} className="onboarding__dot active"></Link>
                <Link to={routes.auth.index} className="onboarding__dot"></Link>
                <Link to={routes.chooseSocial.index} className="onboarding__dot"></Link>
                <Link to={routes.programs.index} className="onboarding__dot"></Link>
                <Link to={routes.news.index} className="onboarding__dot"></Link>
            </div>
            <Link to={routes.auth.index} className="onboarding__next">Далее</Link>
        </div>
    );
};

export default React.memo(MainOnboarding);