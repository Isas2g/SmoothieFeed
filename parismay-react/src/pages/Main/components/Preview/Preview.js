import * as React from 'react';
import {Link}     from 'react-router-dom';

import social from '@assets/images/bg-social.png';

import {routes} from '@configs/routes';

import './Preview.scss';

const Preview = () => {
	return <div className="container-bg-image-kiwi">
				<img className="preview__image preview__image_social" src={social} alt="#"/>
				<div className="container">
					<div className="main__preview preview">
						<h1 className="preview__title">Заголовок</h1>
						<h3 className="preview__description">Выбери уже существующую программу digital-детокса или
							создай свою!</h3>
						<Link to={routes.programs.index} className="preview__button action-button">
							Ознакомиться
						</Link>
					</div>
				</div>
			</div>;
};


export default React.memo(Preview);