import * as React from 'react';

import './Step.scss';

const Step = ({id, el}) => {
	return <div className="step">
		<div className="step__icon">
			<img src={el.image} alt='#'/>
		</div>
		<div className="step__description">
			<div className="step__title">{`${id}. ${el.title}`}</div>
			<div className="step__subtitle">{el.description}</div>
		</div>
	</div>;
};

export default React.memo(Step);