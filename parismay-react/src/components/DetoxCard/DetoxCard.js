import * as React from 'react';

import easyImage   from '@assets/images/easy-cocktail.png';
import mediumImage from '@assets/images/medium-cocktail.png';
import hardImage   from '@assets/images/hard-cocktail.png';
import glass       from '@assets/images/glass.svg';

import './DetoxCard.scss';

const DetoxCard = ({el}) => {
	const details = React.useRef(null),
		button = React.useRef(null);
	
	const data = React.useMemo(() => {
		switch (el[0]) {
			case 'easy':
				return {image: easyImage, color: '#FBE6C0', textColor: '#B48160'};
			case 'medium':
				return {image: mediumImage, color: '#F2E2D8', textColor: '#980120'};
			case 'hard':
				return {image: hardImage, color: '#D6DECB', textColor: '#607C2F'};
			default:
				return {image: '#', color: null, textColor: null};
		}
	}, [el]);
	
	return <div className="detox-card" style={{backgroundColor: data.color}}>
		<div className="detox-card__title">
			<img src={glass} alt="#"/>
			<h2 className="detox-card__title-text">
				{el[0]}
			</h2>
			<img src={glass} alt="#"/>
		</div>
		<ul className="detox-card__details" ref={details}>
			<li className="detox-card__li">{el[1].news} постов в день</li>
			<li className="detox-card__li">{el[1].time} минут просмотра</li>
		</ul>
		<img className="detox-card__image" src={data.image} alt="#"/>
		<div className="detox-card__submit" style={{color: data.textColor}}>Выбрать</div>
	</div>;
};

export default React.memo(DetoxCard);