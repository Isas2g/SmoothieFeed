import * as React from 'react';
import cn         from 'classnames';

import vkIcon      from '@assets/images/social-vk.svg';
import instIcon    from '@assets/images/social-instagram.svg';
import fbIcon      from '@assets/images/social-facebook.svg';
import twitterIcon from '@assets/images/social-twitter-2.svg';

import './FilterSocial.scss';

const FilterSocial = () => {
	const [vkStatus, setVKStatus] = React.useState(localStorage.getItem('vkStatus')),
		[instStatus, setInstStatus] = React.useState(localStorage.getItem('instStatus')),
		[fbStatus, setFBStatus] = React.useState(localStorage.getItem('fbStatus')),
		[twitterStatus, setTwitterStatus] = React.useState(localStorage.getItem('twitterStatus'));
	
	return <div className="filter-social">
		<img
			className={cn('filter-social__item', vkStatus === 'true' ? 'filter-social__item_active' : null)}
			src={vkIcon}
			alt="VK"
			onClick={() => {
				if (vkStatus === 'false') {
					setVKStatus('true');
					localStorage.setItem('vkStatus', 'true');
				} else {
					setVKStatus('false');
					localStorage.setItem('vkStatus', 'false');
				}
			}}
		/>
		<img
			className={cn('filter-social__item', instStatus === 'true' ? 'filter-social__item_active' : null)}
			src={instIcon}
			alt="Instagram"
			onClick={() => {
				if (instStatus === 'false') {
					setInstStatus('true');
					localStorage.setItem('instStatus', 'true');
				} else {
					setInstStatus('false');
					localStorage.setItem('instStatus', 'false');
				}
			}}
		/>
		<img
			className={cn('filter-social__item', fbStatus === 'true' ? 'filter-social__item_active' : null)}
			src={fbIcon}
			alt="Facebook"
			onClick={() => {
				if (fbStatus === 'false') {
					setFBStatus('true');
					localStorage.setItem('fbStatus', 'true');
				} else {
					setFBStatus('false');
					localStorage.setItem('fbStatus', 'false');
				}
			}}
		/>
		<img
			className={cn('filter-social__item', twitterStatus === 'true' ? 'filter-social__item_active' : null)}
			src={twitterIcon}
			alt="Twitter"
			onClick={() => {
				if (twitterStatus === 'false') {
					setTwitterStatus('true');
					localStorage.setItem('twitterStatus', 'true');
				} else {
					setTwitterStatus('false');
					localStorage.setItem('twitterStatus', 'false');
				}
			}}
		/>
	</div>;
};

export default React.memo(FilterSocial);