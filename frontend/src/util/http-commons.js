import axios from 'axios';

// const { VUE_APP_API_BASE_URL } = import.meta.env;

// const baseURL = process.env.BASE_URL;

// // local vue api axios instance
function localAxios() {
    const instance = axios.create({
        // baseURL: VUE_APP_API_BASE_URL,
        baseURL : "http://localhost:8080/trip",
        headers: {
            'Content-Type': 'application/json;charset=utf-8',
        },
    });
    return instance;
}

// //public data vue api axios instance
// function publicDataAxios() {
//     const instance = axios.create({
//         baseURL: VITE_VUE_API_URL,
//         headers: {
//             'Content-Type': 'application/json;charset=utf-8',
//         },
//     });
//     return instance;
// }

export { localAxios };
