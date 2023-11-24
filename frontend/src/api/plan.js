import { localAxios } from '@/util/http-commons';
const local = localAxios();

const url = '/plan';

function getList(memberId, success, fail) {
    console.log('axios 호출');
    // local.get(`${url}/list`).then(success).catch(fail);
    local.get(`${url}/list/${memberId}`).then(success).catch(fail);
}

function writePlan(request, success, fail) {
    console.log(JSON.stringify(request));
    local.post(`${url}/write`, JSON.stringify(request)).then(success).catch(fail);
}

export { getList, writePlan };
