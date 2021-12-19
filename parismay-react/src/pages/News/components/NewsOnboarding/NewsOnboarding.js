import React from 'react';
import woman from "@assets/images/onboarding-news.png";
import {Link} from "react-router-dom";
import {routes} from "@configs/routes";

const NewsOnboarding = () => {
    return (
        <div className="onboarding">
            <img src={woman} alt="" className="onboarding__woman woman"/>
            <div className="onboarding__dots">
                <Link to={routes.home.index} className="onboarding__dot"></Link>
                <Link to={routes.auth.index} className="onboarding__dot"></Link>
                <Link to={routes.chooseSocial.index} className="onboarding__dot"></Link>
                <Link to={routes.programs.index} className="onboarding__dot"></Link>
                <Link to={routes.news.index} className="onboarding__dot active"></Link>
            </div>
            <Link to="#" className="onboarding__next">Завершить</Link>
        </div>
    );
};

export default React.memo(NewsOnboarding);