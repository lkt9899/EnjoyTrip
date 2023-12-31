import { localAxios } from '@/util/http-commons';
const local = localAxios();

const url = '/attraction';

function getList(params, success, fail) {
    console.log('axios 호출');
    // local.get(`${url}/list`).then(success).catch(fail);
    local.post(`${url}/list`, params).then(success).catch(fail);
}

function getListByUser(params, success, fail) {
    console.log('getListByUser axios 호출');
    // local.get(`${url}/list`).then(success).catch(fail);
    local.post(`${url}/mainList`, params).then(success).catch(fail);
}

// function detailArticle(articleno, success, fail) {
//     local.get(`${url}/${articleno}`).then(success).catch(fail);
// }

// function getModifyArticle(articleno, success, fail) {
//     local.get(`${url}/modify/${articleno}`).then(success).catch(fail);
// }

// function modifyArticle(article, success, fail) {
//     local.put(`${url}`, JSON.stringify(article)).then(success).catch(fail);
// }

// function deleteArticle(articleno, success, fail) {
//     local.delete(`${url}/${articleno}`).then(success).catch(fail);
// }

export { getList, getListByUser };
