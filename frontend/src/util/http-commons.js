import axios from 'axios';
import { httpStatusCode } from './http-status';

const { VITE_APP_API_BASE_URL } = import.meta.env;

// // local vue api axios instance
function localAxios() {
    const instance = axios.create({
        baseURL: VITE_APP_API_BASE_URL,
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
    });
    // Request 발생 시 적용할 내용
    instance.defaults.headers.common['Authorization'] = '';
    instance.defaults.headers.post['Content-Type'] = 'application/json';
    instance.defaults.headers.put['Content-Type'] = 'application/json';

    // Request, Response 시 설정한 내용을 적용.
    instance.interceptors.request.use((config) => {
        return config;
    }),
        (error) => {
            return Promise.reject(error);
        };

    let isTokenRefreshing = false;

    instance.interceptors.response.use(
        (response) => {
            return response;
        },
        async (error) => {
            const {
                config,
                response: { status },
            } = error;

            if (status == httpStatusCode.UNAUTHORIZED) {
                const originalRequest = config;

                if (!isTokenRefreshing) {
                    isTokenRefreshing = true;

                    return await instance.post('/member/refresh').then((response) => {
                        const newAccessToken = response.data.Authorization;

                        instance.defaults.headers.common['Authorization'] = newAccessToken;
                        originalRequest.headers.Authorization = newAccessToken;

                        isTokenRefreshing = false;

                        // 에러가 발생했던 원래의 요청을 다시 진행.
                        return instance(originalRequest);
                    });
                }
            } else if (status == httpStatusCode.FORBIDDEN) {
                alert(error.response.data.message);
            }

            return Promise.reject(error);
        }
    );
    return instance;
}

export { localAxios };
