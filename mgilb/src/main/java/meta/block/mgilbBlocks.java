package meta.block;

import meta.item.Item_MetaG;
import meta.item.mgilbGroup;
import meta.mgilb.mgilb;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class mgilbBlocks {
    public static final DeferredRegister<Block> BLOCKS
            =DeferredRegister.create(ForgeRegistries.BLOCKS, mgilb.MOD_ID);

    public static final RegistryObject<Block> FIRE_BLOCK = registerBlock("fireblock",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE)
                    .harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name,RegistryObject<T> block){
        Item_MetaG.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties().tab(mgilbGroup.MGILB_GROUP)));
    }

    public static void register(IEventBus eventBus){
        eventBus.register(BLOCKS);
    }
}
