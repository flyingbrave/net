package com.yxy.okhttp

import java.util.*

/**
 * build模式构建全局网络请求对象，网络请求的入口
 */
open class OkHttpClient private constructor(build: Builder) {
    /**
     * 设置网络请求的重试次数
     */
    private var retryTime = 3

    /**
     * 调度器
     */
    private var dispatcher: Dispatcher? = null

    /**
     *拦截器集合
     */
    private var interceptors: MutableList<Interceptor>? = null

    /**
     *服用连接池
     */
    private var connectionPool: ConnectionPool? = null


    init {
        retryTime = build.retryTime
        dispatcher = build.dispatcher
        interceptors = build.interceptors
        connectionPool = build.connectionPool
    }

    companion object {
        final class Builder {
            var retryTime = 0
            var dispatcher: Dispatcher? = null
            var connectionPool: ConnectionPool? = null
            var interceptors: MutableList<Interceptor> = ArrayList()

            fun setRetryTime(retryTime: Int): Builder {
                this.retryTime = retryTime
                return this
            }

            fun setDispatcher(dispatcher: Dispatcher): Builder {
                dispatcher?.let {
                    this.dispatcher = it
                }
                return this
            }

            fun setConnectionPool(connectionPool: ConnectionPool): Builder {
                connectionPool?.let {
                    this.connectionPool = it
                }
                return this
            }

            fun addInterceptors(interceptor: Interceptor?): Builder {
                interceptor?.let { interceptors.add(it) }
                return this
            }

            fun build(): OkHttpClient {
                if (connectionPool == null) {
                    connectionPool = ConnectionPool()
                }
                if (dispatcher == null) {
                    dispatcher = Dispatcher()
                }
                return OkHttpClient(this)
            }

        }
    }

}