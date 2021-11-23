import * as React from 'react';

import './Step.scss';

const Step = ({id, el}) => {
	return <div className="step">
		<div className="step__icon">
			<img src={el.image} alt='#'/>
		</div>
		<div className="step__description">
			<h4 className="step__title">{`${id}. ${el.title}`}</h4>
			<h5 className="step__subtitle">{el.description}</h5>
		</div>
	</div>;
};

export default React.memo(Step);