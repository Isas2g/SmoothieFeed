import * as React from 'react';
import {Link}     from 'react-router-dom';

import logo    from '@assets/images/logo.png';
import theme   from '@assets/images/theme.svg';
import profile from '@assets/images/icon-profile.svg';

import './Header.scss';

import {routes} from '@configs/routes';

const Header = () => {
	return <header className="header">
		<Link to={routes.home.index}>
			<img className="header__logo" src={logo} alt="Smoothie Feed"/>
		</Link>
		<nav className="header__nav nav">
			<div className="nav__list">
				<Link className="nav__link" to={routes.home.index}>Главная</Link>
				<Link className="nav__link" to={routes.news.index}>Посты</Link>
				<Link className="nav__link" to={routes.programs.index}>Выбор детокса</Link>
				<Link className="nav__link" to={routes.achievements.index}>Достижения</Link>
				<Link className="nav__link" to={routes.about.index}>О приложении</Link>
			</div>
		</nav>
		<Link to={routes.auth.index}>
			<div className="header__auth">
				<img className="header__profile" src={profile} alt="Account"/>
				<p className="header__login">Войти</p>
			</div>
		</Link>
		<img className="header__switch-theme" src={theme} alt="Switch Theme"/>
	</header>;
};

export default React.memo(Header);