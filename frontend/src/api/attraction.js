import { apiInstance } from './index.js';

const api = apiInstance();

const url = '/attraction';

function getAttractionList(success, fail) {
    api.get(`${url}/list`).then(success).catch(fail);
}

export { getAttractionList };