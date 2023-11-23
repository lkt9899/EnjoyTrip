import { localAxios } from '@/util/http-commons';
const local = localAxios();

const url = '/hotplace';

function listHotPlaces(param, success, fail) {
    local.get(`${url}/list/${param}`).then(success).catch(fail);
}

export { listHotPlaces };
