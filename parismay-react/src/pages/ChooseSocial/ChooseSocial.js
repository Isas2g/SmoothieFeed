import React from 'react';
import SocialOnboarding from "@pages/ChooseSocial/components/SocialOnboarding";

import vk from "@assets/images/social-vk.svg";
import instagram from "@assets/images/social-instagram.svg";
import facebook from "@assets/images/social-facebook.svg";
import twitter from "@assets/images/social-twitter.svg";

import "./ChooseSocial.scss";
import social from "@assets/images/bg-social.png";

const ChooseSocial = () => {
    return (
        <main className="main main__choose-social choose-social opacity">
            <SocialOnboarding />
            <img className="preview__image preview__image_social" src={social} alt="#"/>
            <h1 className="choose-social__title">Выбери соцсети для отбора постов</h1>
            <div className="choose-social__icons">
                <a className="choose-social__item" href="#">
                    <img src={vk} alt="vk" className="choose-social__image"/>
                </a>
                <a className="choose-social__item" href="#">
                    <img src={instagram} alt="instagram" className="choose-social__image"/>
                </a>
                <a className="choose-social__item" href="#">
                    <img src={facebook} alt="facebook" className="choose-social__image"/>
                </a>
                <a className="choose-social__item" href="#">
                    <img src={twitter} alt="twitter" className="choose-social__image"/>
                </a>
            </div>
        </main>
    );
};

export default React.memo(ChooseSocial);