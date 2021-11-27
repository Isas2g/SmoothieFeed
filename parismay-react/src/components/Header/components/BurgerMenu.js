import React, {useState} from 'react';
import {Link, useLocation} from 'react-router-dom';
import cn from 'classnames';

import './BurgerMenu.scss';

import burgerProfile from '@assets/images/burger-profile-icon.svg';
import posts from '@assets/images/burger-posts.svg';
import application from '@assets/images/burger-about-application.svg';
import detox from '@assets/images/burger-detox.svg';
import achievements from '@assets/images/burger-achievements.svg';
import profile from '@assets/images/burger-profile.svg';
import switchTheme from '@assets/images/theme.svg';
import cross from '@assets/images/cross.svg';


import { routes } from '@configs/routes';
import {getCLS} from "web-vitals";

const BurgerMenu = ({active, setActive}) => {
    const location = useLocation();

    return (
        <div className={active ? "burger-menu active" : "burger-menu"}>
            <div className="burger-menu__content">
				<img onClick={() => setActive(!active)} className="burger-menu__cross" src={cross} alt="Cross"/>
                <div className="burger-menu__header">
					<img className="burger-menu__profile-icon" src={profile} alt="Profile"/>
					<h3 className="burger-menu__username">Имя пользователя</h3>
				</div>
				<hr className="hr-line"/>
                <nav className="burger-menu__burger-nav burger-nav">
                	<ul className="burger-nav__list">
                        <Link
                			className={cn("burger-nav__link", location.pathname === routes.home.index ? 'burger-nav__link_active' : null)}
                			to={routes.home.index}
                		>
							<img className="burger-nav__icon" src={burgerProfile} alt="Profile" />
							<h4>
								Главная
							</h4>
                        </Link>
                		<Link
                			className={cn("burger-nav__link", location.pathname === routes.news.index ? 'burger-nav__link_active' : null)}
                			to={routes.news.index}
                		>
							<img className="burger-nav__icon" src={posts} alt="Posts"/>
							<h4>
								Посты
                			</h4>
							</Link>
                		<Link
                			className={cn("burger-nav__link", location.pathname === routes.programs.index ? 'burger-nav__link_active' : null)}
                			to={routes.programs.index}
                		>
							<img className="burger-nav__icon" src={detox} alt="Detox programs"/>
							<h4>
								Выбор детокса
                			</h4>
							</Link>
                		<Link
                			className={cn("burger-nav__link", location.pathname === routes.achievements.index ? 'burger-nav__link_active' : null)}
                			to={routes.achievements.index}
                		>
							<img className="burger-nav__icon" src={achievements} alt=""/>
							<h4>
								Достижения
                			</h4>
							</Link>
                		<Link
                			className={cn("burger-nav__link", location.pathname === routes.about.index ? 'burger-nav__link_active' : null)}
                			to={routes.about.index}
                		>
							<img className="burger-nav__icon" src={application} alt="About application"/>
							<h4>
								О приложении
                			</h4>
							</Link>
                	</ul>
                </nav>
				<hr className="burger-menu__hr-line hr-line"/>
				<img className="burger-menu__switch-theme" src={switchTheme} alt="Theme"/>
				<Link className="burger-menu__exit exit"><h4>Выйти</h4></Link>
            </div>
        </div>
    );
};

export default React.memo(BurgerMenu);