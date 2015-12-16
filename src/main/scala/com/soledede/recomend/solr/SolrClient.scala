package com.soledede.recomend.solr

import _root_.search.solr.client.SolrClientConf
import _root_.search.solr.client.impl.SolJSolrCloudClient
import com.soledede.recomend.solr.impl.SolJSolrCloudClient

import scala.reflect.ClassTag

/**
  * Created by soledede on 2015/12/15.
  */
trait SolrClient {

  def searchByQuery[T: ClassTag](query: T, collection: String = "searchcloud"): AnyRef = null

  def close(): Unit = {}
}

object SolrClient {

  def apply(cType: String = "solrJSolrCloud"): SolrClient = {
    cType match {
      case "solrJSolrCloud" => SolJSolrCloudClient()
      case _ => null
    }
  }
}