import * as React from 'react';
import { Link, useLocation } from 'react-router-dom';
import cn from 'classnames';

import logo from '@assets/images/logo.png';
import theme from '@assets/images/theme.svg';
import profile from '@assets/images/icon-profile.svg';

import './Header.scss';

import { routes } from '@configs/routes';

const Header = () => {
	const location = useLocation();

	return <div className="wrapper">
			<header className="header">
				<div className="header__inner container--lg">
					<Link to={routes.home.index}>
						<img className="header__logo logo" src={logo} alt="Smoothie Feed" />
					</Link>
					<nav className="header__nav nav">
						<ul className="nav__list">
							<Link
								className={cn("nav__link", location.pathname === routes.home.index ? 'nav__link_active' : null)}
								to={routes.home.index}
							>Главная</Link>
							<Link
								className={cn("nav__link", location.pathname === routes.news.index ? 'nav__link_active' : null)}
								to={routes.news.index}
							>Посты</Link>
							<Link
								className={cn("nav__link", location.pathname === routes.programs.index ? 'nav__link_active' : null)}
								to={routes.programs.index}
							>Выбор детокса</Link>
							<Link
								className={cn("nav__link", location.pathname === routes.achievements.index ? 'nav__link_active' : null)}
								to={routes.achievements.index}
							>Достижения</Link>
							<Link
								className={cn("nav__link", location.pathname === routes.about.index ? 'nav__link_active' : null)}
								to={routes.about.index}
							>О приложении</Link>
						</ul>
					</nav>
					<Link to={routes.auth.index}>
						<div className="header__auth">
							<img className="header__profile" src={profile} alt="Account" />
							<p className="header__login">Войти</p>
						</div>
					</Link>
					<img className="header__switch-theme" src={theme} alt="Switch Theme" />
				</div>
				<div className="bg"/>
			</header>
		</div>
};

export default React.memo(Header);