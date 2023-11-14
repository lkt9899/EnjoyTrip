import axios from 'axios';
import router from '@/router';
import store from '@/store';

function apiInstance() {
    const instance = axios.create({
        baseURL: import.meta.env.VUE_APP_API_BASE_URL,
        withCredentials: true,
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
    });

    instance.interceptors.response.use(
        function (response) {
            return response;
        },

        // TODO: 로그인 여부 처리
        function (error) {
            if (error.response && error.response.status) {
                switch (error.response.status) {
                    case 401:
                        break;

                    case 406:
                        break;

                    default:
                        break;
                }
            }
        }
    );
    return instance;
}
