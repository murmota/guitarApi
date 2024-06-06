// store/index.js
import { createStore } from 'vuex';
import createPersistedState from 'vuex-persistedstate';

const store = createStore({
  state: {
    token: null,
    roles: []  // Массив ролей
  },
  getters: {
    isLoggedIn: state => !!state.token,
    userRoles: state => state.roles,
  },
  mutations: {
    setToken(state, token) {
      state.token = token;
    },
    setRoles(state, roles) {
      state.roles = roles;
    },
    logout(state) {
      state.token = null;
      state.roles = [];
    }
  },
  actions: {
    login({ commit }, { token, roles }) {
      commit('setToken', token);
      commit('setRoles', roles);
    },
    logout({ commit }) {
      commit('logout');
    }
  },
  plugins: [createPersistedState()]
});

export default store;
