package com.fmpwizard.examples

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URI

import org.apache.http.auth.AuthScheme
import org.apache.http.auth.AuthScope
import org.apache.http.auth.AuthState
import org.apache.http.auth.Credentials
import org.apache.http.auth.UsernamePasswordCredentials

import org.apache.http.client.CredentialsProvider
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.protocol.ClientContext
import org.apache.http.entity.ByteArrayEntity
import org.apache.http.HttpEntity
import org.apache.http.HttpException
import org.apache.http.HttpHost
import org.apache.http.HttpRequestInterceptor
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.impl.auth.BasicScheme

import org.apache.http.protocol.ExecutionContext
import org.apache.http.protocol.BasicHttpContext
import org.apache.http.protocol.HttpContext
import org.apache.http.protocol.SyncBasicHttpContext
import org.apache.http.util.EntityUtils


class URLLineReader(inStream: InputStream) {
  val reader = new BufferedReader(new InputStreamReader(inStream))
  def foldLeft[T](init: T)(f: (T, String) => T): T = reader.readLine match {
    case null => init
    case line => foldLeft(f(init, line + "\n"))(f)
  }
}

