import * as React from 'react';

const MainAboutApplication = () => {
	return <main className="main">
		<div className="container">
			<div className="main__about-app about-app">
				<h1 className="about-app__title main-title">О приложении</h1>
				<p className="about-app__text main-text">
					«SmoothieFeed» - приложение для digital-детокса, в нем собраны ленты всех социальных сетей
					пользователя и он может ограничивать время или количество самых интересных постов в день из
					всех социальных сетей, чтобы не перегружать себя лишней информацией. Пользователь может выбрать
					уже существующую в приложении программу digital-детокса или выбрать свою.
				</p>
			</div>
			<div className="main__leave-review leave-review">
				<h2 className="leave-review__title">Понравилось приложение? <p>Оставь отзыв!</p></h2>
				<button className="leave-review__button action-button">Оставь отзыв!</button>
			</div>
		</div>
	</main>;
};

export default MainAboutApplication;