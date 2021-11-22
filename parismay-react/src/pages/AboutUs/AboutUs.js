import * as React from 'react';

import social from '@assets/images/bg-social.png';

import './AboutUs.scss';

const AboutUs = () => {
	const page = React.useRef(null);
	
	React.useEffect(() => {
		const timeout = setTimeout(() => page.current.classList.add('about-us_active'), 200);
		
		return () => clearTimeout(timeout);
	}, []);
	
	return <div className="about-us" ref={page}>
		<img className="about-us__image" src={social} alt="#"/>
		<h1 className="about-us__title title">О приложении</h1>
		<p className="about-us__description description">
			«SmoothieFeed» - приложение для digital-детокса, в нем собраны ленты всех социальных сетей
			пользователя и он может ограничивать время или количество самых интересных постов в день из
			всех социальных сетей, чтобы не перегружать себя лишней информацией. Пользователь может выбрать
			уже существующую в приложении программу digital-детокса или выбрать свою.
		</p>
		<div className="about-us__leave-review leave-review">
			<h1 className="leave-review__title title">Понравилось приложение?<br/>Оставь отзыв!</h1>
			<div className="leave-review__button action-button">Оставить отзыв</div>
		</div>
	</div>;
};

export default React.memo(AboutUs);