package com.example.myapplication.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import kotlin.reflect.KClass

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@MapKey
annotation class NewsViewModelKey(val value: KClass<out ViewModel>)
