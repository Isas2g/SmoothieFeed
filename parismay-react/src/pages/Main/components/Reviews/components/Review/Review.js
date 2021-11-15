import * as React from 'react';

import star from '@assets/images/star.svg';

import './Review.scss';

const Review = ({el}) => {
	return <div className="review">
		<div className="review__image"/>
		<div className="review__user-info user-info">
			<h4 className="user-info__name">{el.username}</h4>
			<h6 className="user-info__date">{el.date}</h6>
			<h5 className="user-info__text">{el.review}</h5>
		</div>
		<div className="review__score">
			<img
				className="review__star"
				src={star}
				alt="#"
				style={el.stars >= 1 ? {filter: 'none'} : {filter: 'brightness(0)'}}
			/>
			<img
				className="review__star"
				src={star}
				alt="#"
				style={el.stars >= 2 ? {filter: 'none'} : {filter: 'brightness(0)'}}
			/>
			<img
				className="review__star"
				src={star}
				alt="#"
				style={el.stars >= 3 ? {filter: 'none'} : {filter: 'brightness(0)'}}
			/>
			<img
				className="review__star"
				src={star}
				alt="#"
				style={el.stars >= 4 ? {filter: 'none'} : {filter: 'brightness(0)'}}
			/>
			<img
				className="review__star"
				src={star}
				alt="#"
				style={el.stars === 5 ? {filter: 'none'} : {filter: 'brightness(0)'}}
			/>
		</div>
	</div>;
};

export default React.memo(Review);