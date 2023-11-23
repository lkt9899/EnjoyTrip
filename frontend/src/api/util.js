import { localAxios } from '@/util/http-commons';

const local = localAxios();

function statistics(success, fail) {
    local.get(`/util/statistics`).then(success).catch(fail);
}
export { statistics };
