package com.homeworkhopper;

import java.util.Iterator;
import java.util.Optional;

import static com.homeworkhopper.Tuple.*;

/**
 * An ordered collection of items which don't necessarily share the same type.
 * <p>
 * Like Sets and Lists, tuples are capable of storing different kinds of items, however tuples are distinct in the
 * sense that the type of each item is maintained. Additionally, tuples are always immutable, whereas Sets and Lists
 * are typically not.
 * <p>
 * The use of tuples in a statically typed language such as Java introduces a handful of inconvenient and annoying side
 * effects which are only worsened by the way in which the Java language implements generic types. Specifically
 * speaking, both the number of items and type of each individual item within a given tuple must be explicitly defined
 * in order for the types of those items to be properly maintained.
 * <p>
 * The {@code Tuple} interface provides static factory methods capable of producing tuples of up to seven items in
 * size, as this is the maximum tuple size supported by this interface. If more than seven items need to be stored,
 * a tuple may be created with another tuple an eighth (and final) item. This functionality allows for tuple objects
 * to be nested and effectively allows for arbitrarily large tuples with more than seven items to be created.
 *
 * @author Shaun Thornton
 * @see Tuple.Single
 * @see Tuple.OfTwo
 * @see Tuple.OfThree
 * @see Tuple.OfFour
 * @see Tuple.OfFive
 * @see Tuple.OfSix
 * @see Tuple.OfSeven
 * @see Tuple.OfNested
 * @see Tuple.TupleValue
 */
public sealed interface Tuple extends Iterable<TupleValue>
        permits Single, OfTwo, OfThree, OfFour, OfFive, OfSix, OfSeven, OfNested {

    /**
     * Returns a String representation of a given {@code Tuple} value.
     * <p>
     * This static method is called from the {@code toString()} methods of all subclasses in order to ensure consistent
     * {@code String} representations of all {@code Tuple} objects.
     *
     * @param tuple A tuple object
     * @return A string representation of the provided Tuple object
     */
    static String toString(final Tuple tuple) {
        final Iterator<TupleValue> iterator = tuple.iterator();
        // It is safe to assume that the provided tuple contains at least one item
        final StringBuilder sb = new StringBuilder("(").append(iterator.next().value);
        // The provided tuple MAY contain further items
        iterator.forEachRemaining(tupleValue -> sb.append(", ").append(tupleValue.value));
        return sb.append(")").toString();
    }

    /**
     * Returns a new {@code Tuple.Single} containing one item.
     *
     * @param <OnlyType> the sole item type
     * @param item1      the sole item
     * @return a {@code Tuple.Single} containing the specified item
     */
    static <OnlyType>
    Single<OnlyType>
    of(final OnlyType item1) {
        // Return a new tuple containing the specified item
        return new Single<>(item1);
    }

    /**
     * Returns a new {@code Tuple.OfTwo} containing two items.
     *
     * @param <TypeA> the first item type
     * @param <TypeB> the second item type
     * @param item1   the first item
     * @param item2   the second item
     * @return a {@code Tuple.OfTwo} containing the specified items
     */
    static <TypeA, TypeB>
    OfTwo<TypeA, TypeB>
    of(final TypeA item1, final TypeB item2) {
        // Return a new tuple containing the two specified items
        return new OfTwo<>(item1, item2);
    }

    /**
     * Returns a new {@code Tuple.OfThree} containing three items.
     *
     * @param <TypeA> the first item type
     * @param <TypeB> the second item type
     * @param <TypeC> the third item type
     * @param item1   the first item
     * @param item2   the second item
     * @param item3   the third item
     * @return a {@code Tuple.OfThree} containing the specified items
     */
    static <TypeA, TypeB, TypeC>
    OfThree<TypeA, TypeB, TypeC>
    of(final TypeA item1, final TypeB item2, final TypeC item3) {
        // Return a new tuple containing the three specified items
        return new OfThree<>(item1, item2, item3);
    }

    /**
     * Returns a new {@code Tuple.OfFour} containing four items.
     *
     * @param <TypeA> the first item type
     * @param <TypeB> the second item type
     * @param <TypeC> the third item type
     * @param <TypeD> the fourth item type
     * @param item1   the first item
     * @param item2   the second item
     * @param item3   the third item
     * @param item4   the fourth item
     * @return a {@code Tuple.OfFour} containing the specified items
     */
    static <TypeA, TypeB, TypeC, TypeD>
    OfFour<TypeA, TypeB, TypeC, TypeD>
    of(final TypeA item1, final TypeB item2, final TypeC item3, final TypeD item4) {
        // Return a new tuple containing the four specified items
        return new OfFour<>(item1, item2, item3, item4);
    }

    /**
     * Returns a new {@code Tuple.OfFive} containing five items.
     *
     * @param <TypeA> the first item type
     * @param <TypeB> the second item type
     * @param <TypeC> the third item type
     * @param <TypeD> the fourth item type
     * @param <TypeE> the fifth item type
     * @param item1   the first item
     * @param item2   the second item
     * @param item3   the third item
     * @param item4   the fourth item
     * @param item5   the fifth item
     * @return a {@code Tuple.OfFive} containing the specified items
     */
    static <TypeA, TypeB, TypeC, TypeD, TypeE>
    OfFive<TypeA, TypeB, TypeC, TypeD, TypeE>
    of(final TypeA item1, final TypeB item2, final TypeC item3, final TypeD item4, final TypeE item5) {
        // Return a new tuple containing the five specified items
        return new OfFive<>(item1, item2, item3, item4, item5);
    }

    /**
     * Returns a new {@code Tuple.OfSix} containing six items.
     *
     * @param <TypeA> the first item type
     * @param <TypeB> the second item type
     * @param <TypeC> the third item type
     * @param <TypeD> the fourth item type
     * @param <TypeE> the fifth item type
     * @param <TypeF> the sixth item type
     * @param item1   the first item
     * @param item2   the second item
     * @param item3   the third item
     * @param item4   the fourth item
     * @param item5   the fifth item
     * @param item6   the sixth item
     * @return a {@code Tuple.OfSix} containing the specified items
     */
    static <TypeA, TypeB, TypeC, TypeD, TypeE, TypeF>
    OfSix<TypeA, TypeB, TypeC, TypeD, TypeE, TypeF>
    of(final TypeA item1, final TypeB item2, final TypeC item3, final TypeD item4, final TypeE item5,
       final TypeF item6) {
        // Return a new tuple containing the six specified items
        return new OfSix<>(item1, item2, item3, item4, item5, item6);
    }

    /**
     * Returns a new {@code Tuple.OfSeven} containing seven items.
     *
     * @param <TypeA> the first item type
     * @param <TypeB> the second item type
     * @param <TypeC> the third item type
     * @param <TypeD> the fourth item type
     * @param <TypeE> the fifth item type
     * @param <TypeF> the sixth item type
     * @param <TypeG> the seventh item type
     * @param item1   the first item
     * @param item2   the second item
     * @param item3   the third item
     * @param item4   the fourth item
     * @param item5   the fifth item
     * @param item6   the sixth item
     * @param item7   the seventh item
     * @return a {@code Tuple.OfSeven} containing the specified items
     */
    static <TypeA, TypeB, TypeC, TypeD, TypeE, TypeF, TypeG>
    OfSeven<TypeA, TypeB, TypeC, TypeD, TypeE, TypeF, TypeG>
    of(final TypeA item1, final TypeB item2, final TypeC item3, final TypeD item4, final TypeE item5, final TypeF item6,
       final TypeG item7) {
        // Return a new tuple containing the seven specified items
        return new OfSeven<>(item1, item2, item3, item4, item5, item6, item7);
    }

    /**
     * Returns a new {@code Tuple.OfEight} containing eight items.
     * <p>
     * Please note that the eighth item must be another {@code Tuple}
     *
     * @param <TypeA> the first item type
     * @param <TypeB> the second item type
     * @param <TypeC> the third item type
     * @param <TypeD> the fourth item type
     * @param <TypeE> the fifth item type
     * @param <TypeF> the sixth item type
     * @param <TypeG> the seventh item type
     * @param <TypeH> the eighth item type which extends {@code Tuple}
     * @param item1   the first item
     * @param item2   the second item
     * @param item3   the third item
     * @param item4   the fourth item
     * @param item5   the fifth item
     * @param item6   the sixth item
     * @param item7   the seventh item
     * @param rest    the eighth item of type {@code Tuple}
     * @return a {@code Tuple.OfSeven} containing the specified items
     */
    static <TypeA, TypeB, TypeC, TypeD, TypeE, TypeF, TypeG, TypeH extends Tuple>
    OfNested<TypeA, TypeB, TypeC, TypeD, TypeE, TypeF, TypeG, TypeH>
    of(final TypeA item1, final TypeB item2, final TypeC item3, final TypeD item4, final TypeE item5, final TypeF item6,
       final TypeG item7, final TypeH rest) {
        // Return a new tuple containing the eight specified items, as well as another tuple
        return new OfNested<>(item1, item2, item3, item4, item5, item6, item7, rest);
    }

    /**
     * Returns an array containing all the items in this {@code Tuple}.
     * <p>
     * Nested tuples (in which the eighth item of a Tuple is another tuple object) are properly handled, meaning that
     * the array returned by this method will contain unpacked nested items if any are present.
     *
     * @return An array of this {@code Tuple}'s items
     */
    Object[] items();

    /**
     * Returns an array containing the types of each item in this {@code Tuple}
     * The types returned by this method are backed by the {@code items()} method.
     *
     * @return An array of this {@code Tuple}'s types
     */
    default Class<?>[] types() {
        final Object[] items = this.items();
        final int size = items.length;
        final Class<?>[] types = new Class<?>[size];
        for (int i = 0; i < size; i++)
            types[i] = items[i].getClass();
        return types;
    }

    /**
     * Returns {@code true} if this tuple nests another tuple. This will be true if, and only if, this tuple is an
     * {@code Tuple.OfNested} instance.
     *
     * @return {@code true} if this tuple nests another tuple
     */
    default boolean isNested() {
        return this.getClass() == OfNested.class;
    }

    /**
     * Returns an iterator which returns all the items in this tuple in proper sequence.
     * <p>
     * Since the returned iterator is backed by the {@code items()} method, nested tuples can be properly iterated over.
     *
     * @return an iterator over the items in this tuple in proper sequence
     */
    default Iterator<TupleValue> iterator() {
        return new Iterator<>() {
            private final Object[] items = items();

            private int pos = 0;

            @Override
            public boolean hasNext() {
                return this.items.length > pos;
            }

            @Override
            public TupleValue next() {
                return new TupleValue(this.items[pos], this.items[pos++].getClass());
            }
        };
    }

    /**
     * Returns the number of items in this {@code Tuple}.
     * <p>
     * The size returned by this method is backed by {@code items()} method. Nested tuples (in which the eighth item
     * of a Tuple is another tuple object) are properly handled, meaning that the size returned by this method will
     * represent the size of this tuple plus the nested tuple's size if one is present.
     *
     * @return the number of items in this {@code Tuple}
     */
    default int size() {
        // The array returned by the overridden items() method includes all items, included nested ones.
        return this.items().length;
    }

    /**
     * Attempts to represent this tuple as an {@code Tuple.Single} of the specified type. If this tuple is not an
     * {@code Tuple.Single} instance, or does not conform to the specified type, {@code Optional.empty()} is returned.
     * <p>
     * Default implementation returns {@code Optional.empty()}.
     *
     * @param typeA      the desired type's class
     * @param <DesiredA> the desired type
     * @return An {@code Optional} containing an {@code Tuple.Single} representation of this tuple. If this tuple cannot
     * be represented as an {@code Tuple.Single}, {@code Optional.empty()} is returned instead.
     */
    default <DesiredA> Optional<Single<DesiredA>> asSingle(final Class<DesiredA> typeA) {
        // Default implementation returns Optional.empty()
        return Optional.empty();
    }

    /**
     * Attempts to represent this tuple as an {@code Tuple.OfTwo} of the specified types. If this tuple is not an
     * {@code Tuple.OfTwo} instance, or does not conform to the specified types, {@code Optional.empty()} is returned.
     * <p>
     * Default implementation returns {@code Optional.empty()}.
     *
     * @param typeA      the first desired type's class
     * @param typeB      the second desired type's class
     * @param <DesiredA> the first desired type
     * @param <DesiredB> the second desired type
     * @return An {@code Optional} containing an {@code Tuple.OfTwo} representation of this tuple. If this tuple cannot
     * be represented as an {@code Tuple.OfTwo}, {@code Optional.empty()} is returned instead.
     */
    default <DesiredA, DesiredB>
    Optional<OfTwo<DesiredA, DesiredB>>
    asTwo(final Class<DesiredA> typeA, final Class<DesiredB> typeB) {
        // Default implementation returns Optional.empty()
        return Optional.empty();
    }

    /**
     * Attempts to represent this tuple as an {@code Tuple.OfTwo} of the specified types. If this tuple is not an
     * {@code Tuple.OfTwo} instance, or does not conform to the specified types, {@code Optional.empty()} is returned.
     * <p>
     * This is a specialized version of the {@code asTwo(typeA, typeB)} method which assumes that all items contained
     * within the tuple can be represented as the specified type.
     * <p>
     * Default implementation returns {@code Optional.empty()}.
     *
     * @param onlyType   the singular desired type's class
     * @param <OnlyType> the singular desired type
     * @return An {@code Optional} containing an {@code Tuple.OfTwo} representation of this tuple. If this tuple cannot
     * be represented as an {@code Tuple.OfTwo}, {@code Optional.empty()} is returned instead.
     */
    default <OnlyType>
    Optional<OfTwo<OnlyType, OnlyType>>
    asTwo(final Class<OnlyType> onlyType) {
        // Delegate to explicit type implementation
        return this.asTwo(onlyType, onlyType);
    }

    /**
     * Attempts to represent this tuple as an {@code Tuple.OfThree} of the specified types. If this tuple is not an
     * {@code Tuple.OfThree} instance, or does not conform to the specified types, {@code Optional.empty()} is returned.
     * <p>
     * Default implementation returns {@code Optional.empty()}.
     *
     * @param typeA      the first desired type's class
     * @param typeB      the second desired type's class
     * @param typeC      the third desired type's class
     * @param <DesiredA> the first desired type
     * @param <DesiredB> the second desired type
     * @param <DesiredC> the third desired type
     * @return An {@code Optional} containing an {@code Tuple.OfThree} representation of this tuple. If this tuple
     * cannot be represented as an {@code Tuple.OfThree}, {@code Optional.empty()} is returned instead.
     */
    default <DesiredA, DesiredB, DesiredC>
    Optional<OfThree<DesiredA, DesiredB, DesiredC>>
    asThree(final Class<DesiredA> typeA, final Class<DesiredB> typeB, final Class<DesiredC> typeC) {
        // Default implementation returns Optional.empty()
        return Optional.empty();
    }

    /**
     * Attempts to represent this tuple as an {@code Tuple.OfThree} of the specified types. If this tuple is not an
     * {@code Tuple.OfThree} instance, or does not conform to the specified types, {@code Optional.empty()} is returned.
     * <p>
     * This is a specialized version of the {@code asThree(typeA, typeB, typeC)} method which assumes that all items
     * contained within the tuple can be represented as the specified type.
     * <p>
     * Default implementation returns {@code Optional.empty()}.
     *
     * @param onlyType   the singular desired type's class
     * @param <OnlyType> the singular desired type
     * @return An {@code Optional} containing an {@code Tuple.OfThree} representation of this tuple. If this tuple
     * cannot be represented as an {@code Tuple.OfThree}, {@code Optional.empty()} is returned instead.
     */
    default <OnlyType>
    Optional<OfThree<OnlyType, OnlyType, OnlyType>>
    asThree(final Class<OnlyType> onlyType) {
        // Delegate to explicit type implementation
        return this.asThree(onlyType, onlyType, onlyType);
    }

    /**
     * Attempts to represent this tuple as an {@code Tuple.OfFour} of the specified types. If this tuple is not an
     * {@code Tuple.OfFour} instance, or does not conform to the specified types, {@code Optional.empty()} is returned.
     * <p>
     * Default implementation returns {@code Optional.empty()}.
     *
     * @param typeA      the first desired type's class
     * @param typeB      the second desired type's class
     * @param typeC      the third desired type's class
     * @param typeD      the fourth desired type's class
     * @param <DesiredA> the first desired type
     * @param <DesiredB> the second desired type
     * @param <DesiredC> the third desired type
     * @param <DesiredD> the fourth desired type
     * @return An {@code Optional} containing an {@code Tuple.OfFour} representation of this tuple. If this tuple cannot
     * be represented as an {@code Tuple.OfFour}, {@code Optional.empty()} is returned instead.
     */
    default <DesiredA, DesiredB, DesiredC, DesiredD>
    Optional<OfFour<DesiredA, DesiredB, DesiredC, DesiredD>>
    asFour(final Class<DesiredA> typeA, final Class<DesiredB> typeB, final Class<DesiredC> typeC,
           final Class<DesiredD> typeD) {
        // Default implementation returns Optional.empty()
        return Optional.empty();
    }

    /**
     * Attempts to represent this tuple as an {@code Tuple.OfFour} of the specified types. If this tuple is not an
     * {@code Tuple.OfFour} instance, or does not conform to the specified types, {@code Optional.empty()} is returned.
     * <p>
     * This is a specialized version of the {@code asFour(typeA, typeB, typeC, typeD)} method which assumes that all
     * items contained within the tuple can be represented as the specified type.
     * <p>
     * Default implementation returns {@code Optional.empty()}.
     *
     * @param onlyType   the singular desired type's class
     * @param <OnlyType> the singular desired type
     * @return An {@code Optional} containing an {@code Tuple.OfFour} representation of this tuple. If this tuple cannot
     * be represented as an {@code Tuple.OfFour}, {@code Optional.empty()} is returned instead.
     */
    default <OnlyType>
    Optional<OfFour<OnlyType, OnlyType, OnlyType, OnlyType>>
    asFour(final Class<OnlyType> onlyType) {
        // Delegate to explicit type implementation
        return this.asFour(onlyType, onlyType, onlyType, onlyType);
    }

    /**
     * Attempts to represent this tuple as an {@code Tuple.OfFive} of the specified types. If this tuple is not an
     * {@code Tuple.OfFive} instance, or does not conform to the specified types, {@code Optional.empty()} is returned.
     * <p>
     * Default implementation returns {@code Optional.empty()}.
     *
     * @param typeA      the first desired type's class
     * @param typeB      the second desired type's class
     * @param typeC      the third desired type's class
     * @param typeD      the fourth desired type's class
     * @param typeE      the fifth desired type's class
     * @param <DesiredA> the first desired type
     * @param <DesiredB> the second desired type
     * @param <DesiredC> the third desired type
     * @param <DesiredD> the fourth desired type
     * @param <DesiredE> the fifth desired type
     * @return An {@code Optional} containing an {@code Tuple.OfFive} representation of this tuple. If this tuple cannot
     * be represented as an {@code Tuple.OfFive}, {@code Optional.empty()} is returned instead.
     */
    default <DesiredA, DesiredB, DesiredC, DesiredD, DesiredE>
    Optional<OfFive<DesiredA, DesiredB, DesiredC, DesiredD, DesiredE>>
    asFive(final Class<DesiredA> typeA, final Class<DesiredB> typeB, final Class<DesiredC> typeC,
           final Class<DesiredD> typeD, final Class<DesiredE> typeE) {
        // Default implementation returns Optional.empty()
        return Optional.empty();
    }

    /**
     * Attempts to represent this tuple as an {@code Tuple.OfFive} of the specified types. If this tuple is not an
     * {@code Tuple.OfFive} instance, or does not conform to the specified types, {@code Optional.empty()} is returned.
     * <p>
     * This is a specialized version of the {@code asFive(typeA, typeB, typeC, typeD, typeE)} method which assumes that
     * all items contained within the tuple can be represented as the specified type.
     * <p>
     * Default implementation returns {@code Optional.empty()}.
     *
     * @param onlyType   the singular desired type's class
     * @param <OnlyType> the singular desired type
     * @return An {@code Optional} containing an {@code Tuple.OfFive} representation of this tuple. If this tuple cannot
     * be represented as an {@code Tuple.OfFive}, {@code Optional.empty()} is returned instead.
     */
    default <OnlyType>
    Optional<OfFive<OnlyType, OnlyType, OnlyType, OnlyType, OnlyType>>
    asFive(final Class<OnlyType> onlyType) {
        // Delegate to explicit type implementation
        return this.asFive(onlyType, onlyType, onlyType, onlyType, onlyType);
    }

    /**
     * Attempts to represent this tuple as an {@code Tuple.OfSix} of the specified types. If this tuple is not an
     * {@code Tuple.OfSix} instance, or does not conform to the specified types, {@code Optional.empty()} is returned.
     * <p>
     * Default implementation returns {@code Optional.empty()}.
     *
     * @param typeA      the first desired type's class
     * @param typeB      the second desired type's class
     * @param typeC      the third desired type's class
     * @param typeD      the fourth desired type's class
     * @param typeE      the fifth desired type's class
     * @param typeF      the sixth desired type's class
     * @param <DesiredA> the first desired type
     * @param <DesiredB> the second desired type
     * @param <DesiredC> the third desired type
     * @param <DesiredD> the fourth desired type
     * @param <DesiredE> the fifth desired type
     * @param <DesiredF> the sixth desired type
     * @return An {@code Optional} containing an {@code Tuple.OfSix} representation of this tuple. If this tuple cannot
     * be represented as an {@code Tuple.OfSix}, {@code Optional.empty()} is returned instead.
     */
    default <DesiredA, DesiredB, DesiredC, DesiredD, DesiredE, DesiredF>
    Optional<OfSix<DesiredA, DesiredB, DesiredC, DesiredD, DesiredE, DesiredF>>
    asSix(final Class<DesiredA> typeA, final Class<DesiredB> typeB, final Class<DesiredC> typeC,
          final Class<DesiredD> typeD, final Class<DesiredE> typeE, final Class<DesiredF> typeF) {
        // Default implementation returns Optional.empty()
        return Optional.empty();
    }

    /**
     * Attempts to represent this tuple as an {@code Tuple.OfSix} of the specified types. If this tuple is not an
     * {@code Tuple.OfSix} instance, or does not conform to the specified types, {@code Optional.empty()} is returned.
     * <p>
     * This is a specialized version of the {@code asSix(typeA, typeB, typeC, typeD, typeE, typeF)} method which assumes
     * that all items contained within the tuple can be represented as the specified type.
     * <p>
     * Default implementation returns {@code Optional.empty()}.
     *
     * @param onlyType   the singular desired type's class
     * @param <OnlyType> the singular desired type
     * @return An {@code Optional} containing an {@code Tuple.OfSix} representation of this tuple. If this tuple cannot
     * be represented as an {@code Tuple.OfSix}, {@code Optional.empty()} is returned instead.
     */
    default <OnlyType>
    Optional<OfSix<OnlyType, OnlyType, OnlyType, OnlyType, OnlyType, OnlyType>>
    asSix(final Class<OnlyType> onlyType) {
        // Delegate to explicit type implementation
        return this.asSix(onlyType, onlyType, onlyType, onlyType, onlyType, onlyType);
    }

    /**
     * Attempts to represent this tuple as an {@code Tuple.OfSeven} of the specified types. If this tuple is not an
     * {@code Tuple.OfSeven} instance, or does not conform to the specified types, {@code Optional.empty()} is returned.
     * <p>
     * Default implementation returns {@code Optional.empty()}.
     *
     * @param typeA      the first desired type's class
     * @param typeB      the second desired type's class
     * @param typeC      the third desired type's class
     * @param typeD      the fourth desired type's class
     * @param typeE      the fifth desired type's class
     * @param typeF      the sixth desired type's class
     * @param typeG      the seventh desired type's class
     * @param <DesiredA> the first desired type
     * @param <DesiredB> the second desired type
     * @param <DesiredC> the third desired type
     * @param <DesiredD> the fourth desired type
     * @param <DesiredE> the fifth desired type
     * @param <DesiredF> the sixth desired type
     * @param <DesiredG> the seventh desired type
     * @return An {@code Optional} containing an {@code Tuple.OfSeven} representation of this tuple. If this tuple
     * cannot be represented as an {@code Tuple.OfSeven}, {@code Optional.empty()} is returned instead.
     */
    default <DesiredA, DesiredB, DesiredC, DesiredD, DesiredE, DesiredF, DesiredG>
    Optional<OfSeven<DesiredA, DesiredB, DesiredC, DesiredD, DesiredE, DesiredF, DesiredG>>
    asSeven(final Class<DesiredA> typeA, final Class<DesiredB> typeB, final Class<DesiredC> typeC,
            final Class<DesiredD> typeD, final Class<DesiredE> typeE, final Class<DesiredF> typeF,
            final Class<DesiredG> typeG) {
        // Default implementation returns Optional.empty()
        return Optional.empty();
    }

    /**
     * Attempts to represent this tuple as an {@code Tuple.OfSeven} of the specified types. If this tuple is not an
     * {@code Tuple.OfSeven} instance, or does not conform to the specified types, {@code Optional.empty()} is returned.
     * <p>
     * This is a specialized version of the {@code asSeven(typeA, typeB, typeC, typeD, typeE, typeF, typeG)} method
     * which assumes that all items contained within the tuple can be represented as the specified type.
     * <p>
     * Default implementation returns {@code Optional.empty()}.
     *
     * @param onlyType   the singular desired type's class
     * @param <OnlyType> the singular desired type
     * @return An {@code Optional} containing an {@code Tuple.OfSeven} representation of this tuple. If this tuple
     * cannot be represented as an {@code Tuple.OfSeven}, {@code Optional.empty()} is returned instead.
     */
    default <OnlyType>
    Optional<OfSeven<OnlyType, OnlyType, OnlyType, OnlyType, OnlyType, OnlyType, OnlyType>>
    asSeven(final Class<OnlyType> onlyType) {
        // Delegate to explicit type implementation
        return this.asSeven(onlyType, onlyType, onlyType, onlyType, onlyType, onlyType, onlyType);
    }

    /**
     * Attempts to represent this tuple as an {@code Tuple.OfNested} of the specified types. If this tuple is not an
     * {@code Tuple.OfNested} instance, or does not conform to the specified types, {@code Optional.empty()} is
     * returned.
     * <p>
     * Default implementation returns {@code Optional.empty()}.
     *
     * @param typeA      the first desired type's class
     * @param typeB      the second desired type's class
     * @param typeC      the third desired type's class
     * @param typeD      the fourth desired type's class
     * @param typeE      the fifth desired type's class
     * @param typeF      the sixth desired type's class
     * @param typeG      the seventh desired type's class
     * @param <DesiredA> the first desired type
     * @param <DesiredB> the second desired type
     * @param <DesiredC> the third desired type
     * @param <DesiredD> the fourth desired type
     * @param <DesiredE> the fifth desired type
     * @param <DesiredF> the sixth desired type
     * @param <DesiredG> the seventh desired type
     * @return An {@code Optional} containing an {@code Tuple.OfNested} representation of this tuple. If this tuple
     * cannot be represented as an {@code Tuple.OfNested}, {@code Optional.empty()} is returned instead.
     */
    default <DesiredA, DesiredB, DesiredC, DesiredD, DesiredE, DesiredF, DesiredG>
    Optional<OfNested<DesiredA, DesiredB, DesiredC, DesiredD, DesiredE, DesiredF, DesiredG, Tuple>>
    asNested(final Class<DesiredA> typeA, final Class<DesiredB> typeB, final Class<DesiredC> typeC,
             final Class<DesiredD> typeD, final Class<DesiredE> typeE, final Class<DesiredF> typeF,
             final Class<DesiredG> typeG) {
        // Default implementation returns Optional.empty()
        return Optional.empty();
    }

    /**
     * Attempts to represent this tuple as an {@code Tuple.OfNested} of the specified types. If this tuple is not an
     * {@code Tuple.OfNested} instance, or does not conform to the specified types, {@code Optional.empty()} is
     * returned.
     * <p>
     * This is a specialized version of the {@code asNested(typeA, typeB, typeC, typeD, typeE, typeF, typeG)} method
     * which assumes that all items contained within the tuple can be represented as the specified type.
     * <p>
     * Default implementation returns {@code Optional.empty()}.
     *
     * @param onlyType   the singular desired type's class
     * @param <OnlyType> the singular desired type
     * @return An {@code Optional} containing an {@code Tuple.OfNested} representation of this tuple. If this tuple
     * cannot be represented as an {@code Tuple.OfNested}, {@code Optional.empty()} is returned instead.
     */
    default <OnlyType>
    Optional<OfNested<OnlyType, OnlyType, OnlyType, OnlyType, OnlyType, OnlyType, OnlyType, Tuple>>
    asNested(final Class<OnlyType> onlyType) {
        // Delegate to explicit type implementation
        return this.asNested(onlyType, onlyType, onlyType, onlyType, onlyType, onlyType, onlyType);
    }

    /**
     * Represents a tuple object which contains a single item.
     *
     * @param <OnlyType> The type of the sole item contained within the tuple
     */
    record Single<OnlyType>(OnlyType item1) implements Tuple {
        /**
         * Attempts to represent this tuple as an {@code Tuple.Single} of the specified type. Although polymorphism
         * ensures that this tuple will always be an {@code Tuple.Single} instance, the actual type of the sole item
         * could potentially differ. If the sole item contained within this tuple does not conform to the specified
         * type, {@code Optional.empty()} is returned.
         *
         * @param typeA         the desired type's class
         * @param <DesiredType> the desired type
         * @return An {@code Optional} containing an {@code Tuple.Single} representation of this tuple. If this tuple
         * cannot be represented as an {@code Tuple.Single}, {@code Optional.empty()} is returned instead.
         */
        @Override
        @SuppressWarnings("unchecked")
        public <DesiredType> Optional<Single<DesiredType>> asSingle(final Class<DesiredType> typeA) {
            if (typeA.isInstance(item1))
                return Optional.of((Single<DesiredType>) this);
            // Delegate to default implementation
            return Tuple.super.asSingle(typeA);
        }

        @Override
        public Object[] items() {
            return new Object[]{item1};
        }

        @Override
        public String toString() {
            // For consistency purposes, delegate to static toString implementation
            return Tuple.toString(this);
        }
    }

    /**
     * Represents a tuple object which contains two items.
     *
     * @param <TypeA> The type of the first item contained within the tuple
     * @param <TypeB> The type of the second item contained within the tuple
     */
    record OfTwo<TypeA, TypeB>(TypeA item1, TypeB item2) implements Tuple {
        /**
         * Attempts to represent this tuple as an {@code Tuple.OfTwo} of the specified types. Although polymorphism
         * ensures that this tuple will always be an {@code Tuple.OfTwo} instance, the actual types of each item
         * could potentially differ. If the items contained within this tuple do not conform to the specified types,
         * {@code Optional.empty()} is returned.
         *
         * @param typeA      the first desired type's class
         * @param typeB      the second desired type's class
         * @param <DesiredA> the first desired type
         * @param <DesiredB> the second desired type
         * @return An {@code Optional} containing an {@code Tuple.OfTwo} representation of this tuple. If this tuple
         * cannot be represented as an {@code Tuple.OfTwo}, {@code Optional.empty()} is returned instead.
         */
        @Override
        @SuppressWarnings("unchecked")
        public <DesiredA, DesiredB>
        Optional<OfTwo<DesiredA, DesiredB>>
        asTwo(final Class<DesiredA> typeA, final Class<DesiredB> typeB) {
            if (typeA.isInstance(item1) && typeB.isInstance(item2))
                return Optional.of((OfTwo<DesiredA, DesiredB>) this);
            // Delegate to default implementation
            return Tuple.super.asTwo(typeA, typeB);
        }

        @Override
        public Object[] items() {
            return new Object[]{item1, item2};
        }

        @Override
        public String toString() {
            // For consistency purposes, delegate to static toString implementation
            return Tuple.toString(this);
        }
    }

    /**
     * Represents a tuple object which contains three items.
     *
     * @param <TypeA> The type of the first item contained within the tuple
     * @param <TypeB> The type of the second item contained within the tuple
     * @param <TypeC> The type of the third item contained within the tuple
     */
    record OfThree<TypeA, TypeB, TypeC>(TypeA item1, TypeB item2, TypeC item3) implements Tuple {
        /**
         * Attempts to represent this tuple as an {@code Tuple.OfThree} of the specified types. Although polymorphism
         * ensures that this tuple will always be an {@code Tuple.OfThree} instance, the actual types of each item
         * could potentially differ. If the items contained within this tuple do not conform to the specified types,
         * {@code Optional.empty()} is returned.
         *
         * @param typeA      the first desired type's class
         * @param typeB      the second desired type's class
         * @param typeC      the third desired type's class
         * @param <DesiredA> the first desired type
         * @param <DesiredB> the second desired type
         * @param <DesiredC> the third desired type
         * @return An {@code Optional} containing an {@code Tuple.OfThree} representation of this tuple. If this tuple
         * cannot be represented as an {@code Tuple.OfThree}, {@code Optional.empty()} is returned instead.
         */
        @Override
        @SuppressWarnings("unchecked")
        public <DesiredA, DesiredB, DesiredC>
        Optional<OfThree<DesiredA, DesiredB, DesiredC>>
        asThree(final Class<DesiredA> typeA, final Class<DesiredB> typeB, final Class<DesiredC> typeC) {
            if (typeA.isInstance(item1)
                    && typeB.isInstance(item2)
                    && typeC.isInstance(item3))
                return Optional.of((OfThree<DesiredA, DesiredB, DesiredC>) this);
            // Delegate to default implementation
            return Tuple.super.asThree(typeA, typeB, typeC);
        }

        @Override
        public Object[] items() {
            return new Object[]{item1, item2, item3};
        }

        @Override
        public String toString() {
            // For consistency purposes, delegate to static toString implementation
            return Tuple.toString(this);
        }
    }

    /**
     * Represents a tuple object which contains four items.
     *
     * @param <TypeA> The type of the first item contained within the tuple
     * @param <TypeB> The type of the second item contained within the tuple
     * @param <TypeC> The type of the third item contained within the tuple
     * @param <TypeD> The type of the fourth item contained within the tuple
     */
    record OfFour<TypeA, TypeB, TypeC, TypeD>(TypeA item1, TypeB item2, TypeC item3, TypeD item4) implements Tuple {
        /**
         * Attempts to represent this tuple as an {@code Tuple.OfFour} of the specified types. Although polymorphism
         * ensures that this tuple will always be an {@code Tuple.OfFour} instance, the actual types of each item
         * could potentially differ. If the items contained within this tuple do not conform to the specified types,
         * {@code Optional.empty()} is returned.
         *
         * @param typeA      the first desired type's class
         * @param typeB      the second desired type's class
         * @param typeC      the third desired type's class
         * @param typeD      the fourth desired type's class
         * @param <DesiredA> the first desired type
         * @param <DesiredB> the second desired type
         * @param <DesiredC> the third desired type
         * @param <DesiredD> the fourth desired type
         * @return An {@code Optional} containing an {@code Tuple.OfFour} representation of this tuple. If this tuple
         * cannot be represented as an {@code Tuple.OfFour}, {@code Optional.empty()} is returned instead.
         */
        @Override
        @SuppressWarnings("unchecked")
        public <DesiredA, DesiredB, DesiredC, DesiredD>
        Optional<OfFour<DesiredA, DesiredB, DesiredC, DesiredD>>
        asFour(final Class<DesiredA> typeA, final Class<DesiredB> typeB, final Class<DesiredC> typeC,
               final Class<DesiredD> typeD) {
            if (typeA.isInstance(item1)
                    && typeB.isInstance(item2)
                    && typeC.isInstance(item3)
                    && typeD.isInstance(item4))
                return Optional.of((OfFour<DesiredA, DesiredB, DesiredC, DesiredD>) this);
            // Delegate to default implementation
            return Tuple.super.asFour(typeA, typeB, typeC, typeD);
        }

        @Override
        public Object[] items() {
            return new Object[]{item1, item2, item3, item4};
        }

        @Override
        public String toString() {
            // For consistency purposes, delegate to static toString implementation
            return Tuple.toString(this);
        }
    }

    /**
     * Represents a tuple object which contains five items.
     *
     * @param <TypeA> The type of the first item contained within the tuple
     * @param <TypeB> The type of the second item contained within the tuple
     * @param <TypeC> The type of the third item contained within the tuple
     * @param <TypeD> The type of the fourth item contained within the tuple
     * @param <TypeE> The type of the fifth item contained within the tuple
     */
    record OfFive<TypeA, TypeB, TypeC, TypeD, TypeE>(TypeA item1, TypeB item2, TypeC item3, TypeD item4,
                                                     TypeE item5) implements Tuple {
        /**
         * Attempts to represent this tuple as an {@code Tuple.OfFive} of the specified types. Although polymorphism
         * ensures that this tuple will always be an {@code Tuple.OfFive} instance, the actual types of each item
         * could potentially differ. If the items contained within this tuple do not conform to the specified types,
         * {@code Optional.empty()} is returned.
         *
         * @param typeA      the first desired type's class
         * @param typeB      the second desired type's class
         * @param typeC      the third desired type's class
         * @param typeD      the fourth desired type's class
         * @param typeE      the fifth desired type's class
         * @param <DesiredA> the first desired type
         * @param <DesiredB> the second desired type
         * @param <DesiredC> the third desired type
         * @param <DesiredD> the fourth desired type
         * @param <DesiredE> the fifth desired type
         * @return An {@code Optional} containing an {@code Tuple.OfFive} representation of this tuple. If this tuple
         * cannot be represented as an {@code Tuple.OfFive}, {@code Optional.empty()} is returned instead.
         */
        @Override
        @SuppressWarnings("unchecked")
        public <DesiredA, DesiredB, DesiredC, DesiredD, DesiredE>
        Optional<OfFive<DesiredA, DesiredB, DesiredC, DesiredD, DesiredE>>
        asFive(final Class<DesiredA> typeA, final Class<DesiredB> typeB, final Class<DesiredC> typeC,
               final Class<DesiredD> typeD, final Class<DesiredE> typeE) {
            if (typeA.isInstance(item1)
                    && typeB.isInstance(item2)
                    && typeC.isInstance(item3)
                    && typeD.isInstance(item4)
                    && typeE.isInstance(item5))
                return Optional.of((OfFive<DesiredA, DesiredB, DesiredC, DesiredD, DesiredE>) this);
            // Delegate to default implementation
            return Tuple.super.asFive(typeA, typeB, typeC, typeD, typeE);
        }

        @Override
        public Object[] items() {
            return new Object[]{item1, item2, item3, item4, item5};
        }

        @Override
        public String toString() {
            // For consistency purposes, delegate to static toString implementation
            return Tuple.toString(this);
        }
    }

    /**
     * Represents a tuple object which contains six items.
     *
     * @param <TypeA> The type of the first item contained within the tuple
     * @param <TypeB> The type of the second item contained within the tuple
     * @param <TypeC> The type of the third item contained within the tuple
     * @param <TypeD> The type of the fourth item contained within the tuple
     * @param <TypeE> The type of the fifth item contained within the tuple
     * @param <TypeF> The type of the sixth item contained within the tuple
     */
    record OfSix<TypeA, TypeB, TypeC, TypeD, TypeE, TypeF>(TypeA item1, TypeB item2, TypeC item3, TypeD item4,
                                                           TypeE item5, TypeF item6) implements Tuple {
        /**
         * Attempts to represent this tuple as an {@code Tuple.OfSix} of the specified types. Although polymorphism
         * ensures that this tuple will always be an {@code Tuple.OfSix} instance, the actual types of each item
         * could potentially differ. If the items contained within this tuple do not conform to the specified types,
         * {@code Optional.empty()} is returned.
         *
         * @param typeA      the first desired type's class
         * @param typeB      the second desired type's class
         * @param typeC      the third desired type's class
         * @param typeD      the fourth desired type's class
         * @param typeE      the fifth desired type's class
         * @param typeF      the sixth desired type's class
         * @param <DesiredA> the first desired type
         * @param <DesiredB> the second desired type
         * @param <DesiredC> the third desired type
         * @param <DesiredD> the fourth desired type
         * @param <DesiredE> the fifth desired type
         * @param <DesiredF> the sixth desired type
         * @return An {@code Optional} containing an {@code Tuple.OfSix} representation of this tuple. If this tuple
         * cannot be represented as an {@code Tuple.OfSix}, {@code Optional.empty()} is returned instead.
         */
        @Override
        @SuppressWarnings("unchecked")
        public <DesiredA, DesiredB, DesiredC, DesiredD, DesiredE, DesiredF>
        Optional<OfSix<DesiredA, DesiredB, DesiredC, DesiredD, DesiredE, DesiredF>>
        asSix(final Class<DesiredA> typeA, final Class<DesiredB> typeB, final Class<DesiredC> typeC,
              final Class<DesiredD> typeD, final Class<DesiredE> typeE, final Class<DesiredF> typeF) {
            if (typeA.isInstance(item1)
                    && typeB.isInstance(item2)
                    && typeC.isInstance(item3)
                    && typeD.isInstance(item4)
                    && typeE.isInstance(item5)
                    && typeF.isInstance(item6))
                return Optional.of((OfSix<DesiredA, DesiredB, DesiredC, DesiredD, DesiredE, DesiredF>) this);
            // Delegate to default implementation
            return Tuple.super.asSix(typeA, typeB, typeC, typeD, typeE, typeF);
        }

        @Override
        public Object[] items() {
            return new Object[]{item1, item2, item3, item4, item5, item6};
        }

        @Override
        public String toString() {
            // For consistency purposes, delegate to static toString implementation
            return Tuple.toString(this);
        }
    }

    /**
     * Represents a tuple object which contains seven items.
     *
     * @param <TypeA> The type of the first item contained within the tuple
     * @param <TypeB> The type of the second item contained within the tuple
     * @param <TypeC> The type of the third item contained within the tuple
     * @param <TypeD> The type of the fourth item contained within the tuple
     * @param <TypeE> The type of the fifth item contained within the tuple
     * @param <TypeF> The type of the sixth item contained within the tuple
     * @param <TypeG> The type of the seventh item contained within the tuple
     */
    record OfSeven<TypeA, TypeB, TypeC, TypeD, TypeE, TypeF, TypeG>(TypeA item1, TypeB item2, TypeC item3, TypeD item4,
                                                                    TypeE item5, TypeF item6,
                                                                    TypeG item7) implements Tuple {
        /**
         * Attempts to represent this tuple as an {@code Tuple.OfSeven} of the specified types. Although polymorphism
         * ensures that this tuple will always be an {@code Tuple.OfSeven} instance, the actual types of each item
         * could potentially differ. If the items contained within this tuple do not conform to the specified types,
         * {@code Optional.empty()} is returned.
         *
         * @param typeA      the first desired type's class
         * @param typeB      the second desired type's class
         * @param typeC      the third desired type's class
         * @param typeD      the fourth desired type's class
         * @param typeE      the fifth desired type's class
         * @param typeF      the sixth desired type's class
         * @param typeG      the seventh desired type's class
         * @param <DesiredA> the first desired type
         * @param <DesiredB> the second desired type
         * @param <DesiredC> the third desired type
         * @param <DesiredD> the fourth desired type
         * @param <DesiredE> the fifth desired type
         * @param <DesiredF> the sixth desired type
         * @param <DesiredG> the seventh desired type
         * @return An {@code Optional} containing an {@code Tuple.OfSeven} representation of this tuple. If this tuple
         * cannot be represented as an {@code Tuple.OfSeven}, {@code Optional.empty()} is returned instead.
         */
        @Override
        @SuppressWarnings("unchecked")
        public <DesiredA, DesiredB, DesiredC, DesiredD, DesiredE, DesiredF, DesiredG>
        Optional<OfSeven<DesiredA, DesiredB, DesiredC, DesiredD, DesiredE, DesiredF, DesiredG>>
        asSeven(final Class<DesiredA> typeA, final Class<DesiredB> typeB, final Class<DesiredC> typeC,
                final Class<DesiredD> typeD, final Class<DesiredE> typeE, final Class<DesiredF> typeF,
                final Class<DesiredG> typeG) {
            if (typeA.isInstance(item1)
                    && typeB.isInstance(item2)
                    && typeC.isInstance(item3)
                    && typeD.isInstance(item4)
                    && typeE.isInstance(item5)
                    && typeF.isInstance(item6)
                    && typeG.isInstance(item7))
                return Optional.of(
                        (OfSeven<DesiredA, DesiredB, DesiredC, DesiredD, DesiredE, DesiredF, DesiredG>) this
                );
            // Delegate to default implementation
            return Tuple.super.asSeven(typeA, typeB, typeC, typeD, typeE, typeF, typeG);
        }

        @Override
        public Object[] items() {
            return new Object[]{item1, item2, item3, item4, item5, item6, item7};
        }

        @Override
        public String toString() {
            // For consistency purposes, delegate to static toString implementation
            return Tuple.toString(this);
        }
    }

    /**
     * Represents a tuple object which contains seven items and an eighth nested {@code Tuple} object.
     *
     * @param <TypeA> The type of the first item contained within the tuple
     * @param <TypeB> The type of the second item contained within the tuple
     * @param <TypeC> The type of the third item contained within the tuple
     * @param <TypeD> The type of the fourth item contained within the tuple
     * @param <TypeE> The type of the fifth item contained within the tuple
     * @param <TypeF> The type of the sixth item contained within the tuple
     * @param <TypeG> The type of the seventh item contained within the tuple
     * @param <TypeH> The type of the eighth item contained within the tuple. This type must implement the {@code Tuple}
     *                interface.
     */
    record OfNested<TypeA, TypeB, TypeC, TypeD, TypeE, TypeF, TypeG, TypeH extends Tuple>(TypeA item1, TypeB item2,
                                                                                          TypeC item3, TypeD item4,
                                                                                          TypeE item5, TypeF item6,
                                                                                          TypeG item7,
                                                                                          TypeH rest) implements Tuple {
        /**
         * Attempts to represent this tuple as an {@code Tuple.OfNested} of the specified types. Although polymorphism
         * ensures that this tuple will always be an {@code Tuple.OfNested} instance, the actual types of each item
         * could potentially differ. If the items contained within this tuple do not conform to the specified types,
         * {@code Optional.empty()} is returned.
         *
         * @param typeA      the first desired type's class
         * @param typeB      the second desired type's class
         * @param typeC      the third desired type's class
         * @param typeD      the fourth desired type's class
         * @param typeE      the fifth desired type's class
         * @param typeF      the sixth desired type's class
         * @param typeG      the seventh desired type's class
         * @param <DesiredA> the first desired type
         * @param <DesiredB> the second desired type
         * @param <DesiredC> the third desired type
         * @param <DesiredD> the fourth desired type
         * @param <DesiredE> the fifth desired type
         * @param <DesiredF> the sixth desired type
         * @param <DesiredG> the seventh desired type
         * @return An {@code Optional} containing an {@code Tuple.OfNested} representation of this tuple. If this tuple
         * cannot be represented as an {@code Tuple.OfNested}, {@code Optional.empty()} is returned instead.
         */
        @Override
        @SuppressWarnings("unchecked")
        public <DesiredA, DesiredB, DesiredC, DesiredD, DesiredE, DesiredF, DesiredG>
        Optional<OfNested<DesiredA, DesiredB, DesiredC, DesiredD, DesiredE, DesiredF, DesiredG, Tuple>>
        asNested(final Class<DesiredA> typeA, final Class<DesiredB> typeB, final Class<DesiredC> typeC,
                 final Class<DesiredD> typeD, final Class<DesiredE> typeE, final Class<DesiredF> typeF,
                 final Class<DesiredG> typeG) {
            if (typeA.isInstance(item1)
                    && typeB.isInstance(item2)
                    && typeC.isInstance(item3)
                    && typeD.isInstance(item4)
                    && typeE.isInstance(item5)
                    && typeF.isInstance(item6)
                    && typeG.isInstance(item7))
                return Optional.of(
                        (OfNested<DesiredA, DesiredB, DesiredC, DesiredD, DesiredE, DesiredF, DesiredG, Tuple>) this
                );
            // Delegate to default implementation
            return Tuple.super.asNested(typeA, typeB, typeC, typeD, typeE, typeF, typeG);
        }

        @Override
        public Object[] items() {
            final Object[] myItems = new Object[]{item1, item2, item3, item4, item5, item6, item7},
                    restItems = rest.items(), allItems = new Object[myItems.length + restItems.length];
            System.arraycopy(myItems, 0, allItems, 0, myItems.length);
            System.arraycopy(restItems, 0, allItems, myItems.length, restItems.length);
            return allItems;
        }

        @Override
        public String toString() {
            // For consistency purposes, delegate to static toString implementation
            return Tuple.toString(this);
        }
    }

    /**
     * Represents an item contained within a tuple along with its corresponding Class object. This record is used when
     * iterating over a tuple.
     * <p>
     * It is important to note that this neither the item value nor its type can be generified due to the fact that a
     * tuple can contain items of different types.
     */
    record TupleValue(Object value, Class<?> type) {
    }
}