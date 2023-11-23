import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { defineStore } from 'pinia';

import { loginMember } from '@/api/member';
import { httpStatusCode } from '@/util/http-status';

export const useMemberStore = defineStore('memberStore', () => {
    const router = useRouter();

    const isLogin = ref(false);
    const isLoginError = ref(false);
    const userInfo = ref(null);

    const userLogin = async (loginUser) => {
        await loginMember(
            loginUser,
            (response) => {
                if (response.status === httpStatusCode.OK) {
                    userInfo.value = {
                        memberId: response.data.memberId,
                        name: response.data.name,
                    };
                    // console.log("data", data);
                    isLogin.value = true;
                    isLoginError.value = false;
                } else {
                    console.log('로그인 실패했다');
                    isLogin.value = false;
                    isLoginError.value = true;
                }
                router.push({ name: 'home' });
            },
            (error) => {
                console.error(error);
            }
        );
    };

    const userLogout = async () => {
        if (userInfo.value != null) {
            isLogin.value = false;
            userInfo.value = null;
        }
        router.push({ name: 'home' });
    };

    return {
        isLogin,
        isLoginError,
        userInfo,
        userLogin,
        userLogout,
    };
});
