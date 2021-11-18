import * as React from 'react';
import {Link}     from 'react-router-dom';

import social from '@assets/images/bg-social.png';
import kiwi   from '@assets/images/bg-kiwi.png';

import {routes} from '@configs/routes';

import './Preview.scss';

const Preview = () => {
	return <div className="preview">
		<img className="preview__image preview__image_social" src={social} alt="#"/>
		<img className="preview__image preview__image_kiwi" src={kiwi} alt="#"/>
		<div className="preview__title title">Заголовок</div>
		<div className="preview__description description">
			Выберите уже существующую программу digital-детокса или создайте свою!
		</div>
		<Link to={routes.programs.index} className="preview__button action-button">Ознакомиться</Link>
	</div>;
};

export default React.memo(Preview);