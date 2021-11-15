import * as React from 'react';

import Review from './components/Review';

import './Reviews.scss';

const Reviews = ({reviews}) => {
	return <div className="reviews">
		<div className="reviews__title title">Отзывы</div>
		<div className="reviews__list">
			{reviews.map((el, key) => {
				return <Review key={key} el={el}/>
			})}
		</div>
	</div>;
};

export default React.memo(Reviews);