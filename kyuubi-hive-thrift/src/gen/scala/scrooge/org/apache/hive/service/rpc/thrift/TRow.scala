/**
 * Generated by Scrooge
 *   version: 19.12.0
 *   rev: dfdb68cf6b9c501dbbe3ae644504bf403ad76bfa
 *   built at: 20191212-171820
 */
package org.apache.hive.service.rpc.thrift

import com.twitter.io.Buf
import com.twitter.scrooge.{
  InvalidFieldsException,
  LazyTProtocol,
  StructBuilder,
  StructBuilderFactory,
  TFieldBlob,
  ThriftStruct,
  ThriftStructCodec3,
  ThriftStructField,
  ThriftStructFieldInfo,
  ThriftStructMetaData,
  ValidatingThriftStruct,
  ValidatingThriftStructCodec3
}
import org.apache.thrift.protocol._
import org.apache.thrift.transport.TMemoryBuffer
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.Builder
import scala.reflect.{ClassTag, classTag}


object TRow extends ValidatingThriftStructCodec3[TRow] with StructBuilderFactory[TRow] {
  val NoPassthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty[Short, TFieldBlob]
  val Struct: TStruct = new TStruct("TRow")
  val ColValsField: TField = new TField("colVals", TType.LIST, 1)
  val ColValsFieldManifest: Manifest[_root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue]] = implicitly[Manifest[_root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue]]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      ColValsField,
      false,
      true,
      ColValsFieldManifest,
      _root_.scala.None,
      _root_.scala.Some(implicitly[Manifest[org.apache.hive.service.rpc.thrift.TColumnValue]]),
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    )
  )

  lazy val structAnnotations: immutable$Map[String, String] =
    immutable$Map.empty[String, String]

  private val fieldTypes: IndexedSeq[ClassTag[_]] = IndexedSeq(
    classTag[_root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue]].asInstanceOf[ClassTag[_]]
  )

  private[this] val structFields: Seq[ThriftStructField[TRow]] = {
    Seq(
      new ThriftStructField[TRow](
        ColValsField,
        _root_.scala.Some(ColValsFieldManifest),
        classOf[TRow]) {
          def getValue[R](struct: TRow): R = struct.colVals.asInstanceOf[R]
      }
    )
  }

  override lazy val metaData: ThriftStructMetaData[TRow] =
    new ThriftStructMetaData(this, structFields, fieldInfos, Seq(), structAnnotations)

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: TRow): Unit = {
    if (_item.colVals == null) throw new TProtocolException("Required field colVals cannot be null")
  }

  /**
   * Checks that the struct is a valid as a new instance. If there are any missing required or
   * construction required fields, return a non-empty list.
   */
  def validateNewInstance(item: TRow): scala.Seq[com.twitter.scrooge.validation.Issue] = {
    val buf = scala.collection.mutable.ListBuffer.empty[com.twitter.scrooge.validation.Issue]

    if (item.colVals == null)
      buf += com.twitter.scrooge.validation.MissingRequiredField(fieldInfos.apply(0))
    buf ++= validateField(item.colVals)
    buf.toList
  }

  def withoutPassthroughFields(original: TRow): TRow =
    new Immutable(
      colVals =
        {
          val field = original.colVals
          field.map { field =>
            org.apache.hive.service.rpc.thrift.TColumnValue.withoutPassthroughFields(field)
          }
        }
    )

  def newBuilder(): StructBuilder[TRow] = new TRowStructBuilder(_root_.scala.None, fieldTypes)

  override def encode(_item: TRow, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }


  private[this] def lazyDecode(_iprot: LazyTProtocol): TRow = {

    var colVals: _root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue] = _root_.scala.collection.immutable.Nil
    var _got_colVals = false

    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false
    val _start_offset = _iprot.offset

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.LIST =>
    
                colVals = readColValsValue(_iprot)
                _got_colVals = true
              case _actualType =>
                val _expectedType = TType.LIST
                throw new TProtocolException(
                  "Received wrong type for field 'colVals' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    if (!_got_colVals) throw new TProtocolException("Required field 'colVals' was not found in serialized data for struct TRow")
    new LazyImmutable(
      _iprot,
      _iprot.buffer,
      _start_offset,
      _iprot.offset,
      colVals,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  override def decode(_iprot: TProtocol): TRow =
    _iprot match {
      case i: LazyTProtocol => lazyDecode(i)
      case i => eagerDecode(i)
    }

  private[thrift] def eagerDecode(_iprot: TProtocol): TRow = {
    var colVals: _root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue] = _root_.scala.collection.immutable.Nil
    var _got_colVals = false
    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.LIST =>
                colVals = readColValsValue(_iprot)
                _got_colVals = true
              case _actualType =>
                val _expectedType = TType.LIST
                throw new TProtocolException(
                  "Received wrong type for field 'colVals' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    if (!_got_colVals) throw new TProtocolException("Required field 'colVals' was not found in serialized data for struct TRow")
    new Immutable(
      colVals,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    colVals: _root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue] = _root_.scala.collection.immutable.Nil
  ): TRow =
    new Immutable(
      colVals
    )

  def unapply(_item: TRow): _root_.scala.Option[_root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue]] = _root_.scala.Some(_item.colVals)


  @inline private[thrift] def readColValsValue(_iprot: TProtocol): _root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue] = {
    val _list = _iprot.readListBegin()
    if (_list.size == 0) {
      _iprot.readListEnd()
      Nil
    } else {
      val _rv = new _root_.scala.collection.mutable.ArrayBuffer[org.apache.hive.service.rpc.thrift.TColumnValue](_list.size)
      var _i = 0
      while (_i < _list.size) {
        _rv += {
          org.apache.hive.service.rpc.thrift.TColumnValue.decode(_iprot)
        }
        _i += 1
      }
      _iprot.readListEnd()
      _rv
    }
  }

  @inline private def writeColValsField(colVals_item: _root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue], _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(ColValsField)
    writeColValsValue(colVals_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeColValsValue(colVals_item: _root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue], _oprot: TProtocol): Unit = {
    _oprot.writeListBegin(new TList(TType.STRUCT, colVals_item.size))
    colVals_item match {
      case _: IndexedSeq[_] =>
        var _i = 0
        val _size = colVals_item.size
        while (_i < _size) {
          val colVals_item_element = colVals_item(_i)
          colVals_item_element.write(_oprot)
          _i += 1
        }
      case _ =>
        colVals_item.foreach { colVals_item_element =>
          colVals_item_element.write(_oprot)
        }
    }
    _oprot.writeListEnd()
  }


  object Immutable extends ThriftStructCodec3[TRow] {
    override def encode(_item: TRow, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): TRow = TRow.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[TRow] = TRow.metaData
  }

  /**
   * The default read-only implementation of TRow.  You typically should not need to
   * directly reference this class; instead, use the TRow.apply method to construct
   * new instances.
   */
  class Immutable(
      val colVals: _root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends TRow {
    def this(
      colVals: _root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue] = _root_.scala.collection.immutable.Nil
    ) = this(
      colVals,
      immutable$Map.empty[Short, TFieldBlob]
    )
  }

  /**
   * This is another Immutable, this however keeps strings as lazy values that are lazily decoded from the backing
   * array byte on read.
   */
  private[this] class LazyImmutable(
      _proto: LazyTProtocol,
      _buf: Array[Byte],
      _start_offset: Int,
      _end_offset: Int,
      val colVals: _root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends TRow {

    override def write(_oprot: TProtocol): Unit = {
      _oprot match {
        case i: LazyTProtocol => i.writeRaw(_buf, _start_offset, _end_offset - _start_offset)
        case _ => super.write(_oprot)
      }
    }


    /**
     * Override the super hash code to make it a lazy val rather than def.
     *
     * Calculating the hash code can be expensive, caching it where possible
     * can provide significant performance wins. (Key in a hash map for instance)
     * Usually not safe since the normal constructor will accept a mutable map or
     * set as an arg
     * Here however we control how the class is generated from serialized data.
     * With the class private and the contract that we throw away our mutable references
     * having the hash code lazy here is safe.
     */
    override lazy val hashCode = super.hashCode
  }

  /**
   * This Proxy trait allows you to extend the TRow trait with additional state or
   * behavior and implement the read-only methods from TRow using an underlying
   * instance.
   */
  trait Proxy extends TRow {
    protected def _underlying_TRow: TRow
    override def colVals: _root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue] = _underlying_TRow.colVals
    override def _passthroughFields: immutable$Map[Short, TFieldBlob] = _underlying_TRow._passthroughFields
  }
}

/**
 * Prefer the companion object's [[org.apache.hive.service.rpc.thrift.TRow.apply]]
 * for construction if you don't need to specify passthrough fields.
 */
trait TRow
  extends ThriftStruct
  with _root_.scala.Product1[_root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue]]
  with ValidatingThriftStruct[TRow]
  with java.io.Serializable
{
  import TRow._

  def colVals: _root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue]

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1: _root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue] = colVals


  /**
   * Gets a field value encoded as a binary blob using TCompactProtocol.  If the specified field
   * is present in the passthrough map, that value is returned.  Otherwise, if the specified field
   * is known and not optional and set to None, then the field is serialized and returned.
   */
  def getFieldBlob(_fieldId: Short): _root_.scala.Option[TFieldBlob] = {
    lazy val _buff = new TMemoryBuffer(32)
    lazy val _oprot = new TCompactProtocol(_buff)
    _passthroughFields.get(_fieldId) match {
      case blob: _root_.scala.Some[TFieldBlob] => blob
      case _root_.scala.None => {
        val _fieldOpt: _root_.scala.Option[TField] =
          _fieldId match {
            case 1 =>
              if (colVals ne null) {
                writeColValsValue(colVals, _oprot)
                _root_.scala.Some(TRow.ColValsField)
              } else {
                _root_.scala.None
              }
            case _ => _root_.scala.None
          }
        _fieldOpt match {
          case _root_.scala.Some(_field) =>
            _root_.scala.Some(TFieldBlob(_field, Buf.ByteArray.Owned(_buff.getArray())))
          case _root_.scala.None =>
            _root_.scala.None
        }
      }
    }
  }

  /**
   * Collects TCompactProtocol-encoded field values according to `getFieldBlob` into a map.
   */
  def getFieldBlobs(ids: TraversableOnce[Short]): immutable$Map[Short, TFieldBlob] =
    (ids flatMap { id => getFieldBlob(id) map { id -> _ } }).toMap

  /**
   * Sets a field using a TCompactProtocol-encoded binary blob.  If the field is a known
   * field, the blob is decoded and the field is set to the decoded value.  If the field
   * is unknown and passthrough fields are enabled, then the blob will be stored in
   * _passthroughFields.
   */
  def setField(_blob: TFieldBlob): TRow = {
    var colVals: _root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue] = this.colVals
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        colVals = readColValsValue(_blob.read)
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      colVals,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): TRow = {
    var colVals: _root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue] = this.colVals

    _fieldId match {
      case 1 =>
        colVals = _root_.scala.collection.immutable.Nil
      case _ =>
    }
    new Immutable(
      colVals,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetColVals: TRow = unsetField(1)


  override def write(_oprot: TProtocol): Unit = {
    TRow.validate(this)
    _oprot.writeStructBegin(Struct)
    if (colVals ne null) writeColValsField(colVals, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    colVals: _root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue] = this.colVals,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): TRow =
    new Immutable(
      colVals,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[TRow]

  private def _equals(x: TRow, y: TRow): Boolean =
      x.productArity == y.productArity &&
      x.productIterator.sameElements(y.productIterator) &&
      x._passthroughFields == y._passthroughFields

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _equals(this, other.asInstanceOf[TRow])

  override def hashCode: Int = {
    _root_.scala.runtime.ScalaRunTime._hashCode(this)
  }

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 1

  override def productElement(n: Int): Any = n match {
    case 0 => this.colVals
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "TRow"

  def _codec: ValidatingThriftStructCodec3[TRow] = TRow

  def newBuilder(): StructBuilder[TRow] = new TRowStructBuilder(_root_.scala.Some(this), fieldTypes)
}

private[thrift] class TRowStructBuilder(instance: _root_.scala.Option[TRow], fieldTypes: IndexedSeq[ClassTag[_]])
    extends StructBuilder[TRow](fieldTypes) {

  def build(): TRow = instance match {
    case _root_.scala.Some(i) =>
      TRow(
        (if (fieldArray(0) == null) i.colVals else fieldArray(0)).asInstanceOf[_root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue]]
      )
    case _root_.scala.None =>
      if (fieldArray.contains(null)) throw new InvalidFieldsException(structBuildError("TRow"))
      else {
        TRow(
          fieldArray(0).asInstanceOf[_root_.scala.collection.Seq[org.apache.hive.service.rpc.thrift.TColumnValue]]
        )
      }
    }
}
