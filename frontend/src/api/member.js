import { localAxios } from '@/util/http-commons';
import axios from 'axios';
import {ref} from "vue";
const local = localAxios();

const url = '/member';

// function getList(params, success, fail) {
//     // local.get(`${url}/list`).then(success).catch(fail);
//     local.post(`${url}/list`, params)
//         .then(success)
//         .catch(fail);
// }

function loginMember(memberLoginReq, success, fail) {
    console.log('LoginReq : ', memberLoginReq);
    local.post(`${url}/login`, JSON.stringify(memberLoginReq)).then(success).catch(fail);
}

function registerMember(member, success, fail) {
    console.log('register member : ', member);
    local.post(`${url}/register`, JSON.stringify(member)).then(success).catch(fail);
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

export {
    registerMember, loginMember
};
