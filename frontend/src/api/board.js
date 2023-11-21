import { localAxios } from "@/util/http-commons";

const local = localAxios();
const BASE_URL = "/post";

function PostList(param, success, fail) {
    local.post(`${BASE_URL}/list`, param ).then(success).catch(fail);
    // local.get(`${BASE_URL}/list`, { params: param }).then(success).catch(fail);
}
function detailPost(postId, success, fail) {
    local.get(`${BASE_URL}/view/${postId}`).then(success).catch(fail);
}
function deletePost(postId, success, fail) {
    local.delete(`${BASE_URL}/${postId}`).then(success).catch(fail);
}
export {
    PostList,
    detailPost,
    deletePost,
}