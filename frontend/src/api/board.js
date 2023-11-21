import { localAxios } from "@/util/http-commons";

const local = localAxios();
const BASE_URL = "/post";

function PostList(param, success, fail) {
    local.post(`${BASE_URL}/list`, param ).then(success).catch(fail);
    // local.get(`${BASE_URL}/list`, { params: param }).then(success).catch(fail);
}

export {
    PostList,
}