import { localAxios } from '@/util/http-commons';
import axios from 'axios';
import { ref} from "vue";
const local = localAxios();

const url = '/attraction';

function getList(success, fail) {
    local.get(`${url}/list`).then(success).catch(fail);
}

// function detailArticle(articleno, success, fail) {
//     local.get(`${url}/${articleno}`).then(success).catch(fail);
// }

// function registArticle(article, success, fail) {
//     console.log('boardjs article', article);
//     local.post(`${url}`, JSON.stringify(article)).then(success).catch(fail);
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

export {
    getList,
};
